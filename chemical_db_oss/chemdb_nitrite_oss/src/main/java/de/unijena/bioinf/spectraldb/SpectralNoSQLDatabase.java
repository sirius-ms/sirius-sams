/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schilller University.
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with SIRIUS. If not, see <https://www.gnu.org/licenses/lgpl-3.0.txt>
 */

/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2023 Bright Giant GmbH
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with SIRIUS.
 *  If not, see <https://www.gnu.org/licenses/lgpl-3.0.txt>
 */

package de.unijena.bioinf.spectraldb;

import com.google.common.collect.Iterables;
import de.unijena.bioinf.ChemistryBase.ms.Deviation;
import de.unijena.bioinf.ChemistryBase.ms.Ms2Spectrum;
import de.unijena.bioinf.ChemistryBase.ms.Peak;
import de.unijena.bioinf.ChemistryBase.ms.utils.OrderedSpectrum;
import de.unijena.bioinf.ChemistryBase.ms.utils.SimpleSpectrum;
import de.unijena.bioinf.chemdb.ChemicalDatabaseException;
import de.unijena.bioinf.spectraldb.entities.Ms2SpectralData;
import de.unijena.bioinf.spectraldb.entities.Ms2SpectralMetadata;
import de.unijena.bioinf.spectraldb.ser.Ms2SpectralDataDeserializer;
import de.unijena.bioinf.spectraldb.ser.Ms2SpectralDataSerializer;
import de.unijena.bioinf.spectraldb.ser.Ms2SpectralMetadataDeserializer;
import de.unijena.bioinf.spectraldb.ser.Ms2SpectralMetadataSerializer;
import de.unijena.bioinf.storage.db.nosql.*;
import de.unijena.bionf.spectral_alignment.AbstractSpectralAlignment;
import de.unijena.bionf.spectral_alignment.SpectralSimilarity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SpectralNoSQLDatabase<Doctype> implements SpectralLibrary {

    final protected Database<Doctype> storage;

    public SpectralNoSQLDatabase(Database<Doctype> storage) throws IOException {
        this.storage = storage;
    }

    protected static Metadata initMetadata() throws IOException {
        return Metadata.build()
                .addRepository(Tag.class, new Index("key",IndexType.UNIQUE))
                .addRepository(
                        Ms2SpectralMetadata.class,
                        "id",
                        new Ms2SpectralMetadataSerializer(),
                        new Ms2SpectralMetadataDeserializer(),
                        new Index("ionMass", IndexType.NON_UNIQUE),
                        new Index("formula", IndexType.NON_UNIQUE),
                        new Index("name", IndexType.NON_UNIQUE),
                        new Index("candidateInChiKey", IndexType.NON_UNIQUE)
                ).addRepository(
                        Ms2SpectralData.class,
                        "id",
                        new Ms2SpectralDataSerializer(),
                        new Ms2SpectralDataDeserializer(),
                        new Index("metaId", IndexType.NON_UNIQUE),
                        new Index("precursorMz", IndexType.NON_UNIQUE)
                );
    }

    @Override
    public <P extends Peak, A extends AbstractSpectralAlignment> Iterable<Pair<SpectralSimilarity, Ms2SpectralMetadata>> matchingSpectra(
            Ms2Spectrum<P> spectrum,
            Deviation precursorMzDeviation,
            Deviation maxPeakDeviation,
            Class<A> alignmentType
    ) throws ChemicalDatabaseException {
        return matchingSpectra(spectrum, precursorMzDeviation, maxPeakDeviation, alignmentType, false);
    }

    @Override
    public <P extends Peak, A extends AbstractSpectralAlignment> Iterable<Pair<SpectralSimilarity, Ms2SpectralMetadata>> matchingSpectra(
            Ms2Spectrum<P> spectrum,
            Deviation precursorMzDeviation,
            Deviation maxPeakDeviation,
            Class<A> alignmentType,
            boolean parallel
    ) throws ChemicalDatabaseException {
        try {
            PriorityBlockingQueue<Pair<SpectralSimilarity, Ms2SpectralMetadata>> heap = new PriorityBlockingQueue<>(100, (o1, o2) -> - Double.compare(o1.getLeft().similarity, o2.getLeft().similarity));
            A alignment = alignmentType.getConstructor(Deviation.class).newInstance(maxPeakDeviation);
            OrderedSpectrum<Peak> query = new SimpleSpectrum(spectrum);

            Iterable<Ms2SpectralData> spectra = lookupSpectra(spectrum.getPrecursorMz(), precursorMzDeviation);
            StreamSupport.stream(Iterables.partition(spectra, 100).spliterator(), parallel).forEach(chunk -> {
                for (Ms2SpectralData data : chunk) {
                    SpectralSimilarity similarity = alignment.score(query, data);
                    if (similarity.shardPeaks > 0) {
                        try {
                            heap.add(Pair.of(similarity, storage.getById(data.getMetaId(), Ms2SpectralMetadata.class)));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

            List<Pair<SpectralSimilarity, Ms2SpectralMetadata>> result = new ArrayList<>(heap.size());
            heap.drainTo(result);
            return result;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 RuntimeException e) {
            throw new ChemicalDatabaseException(e);
        }
    }

    @Override
    public Iterable<Ms2SpectralData> lookupSpectra(double precursorMz, Deviation deviation) throws ChemicalDatabaseException {
        try {
            double abs = deviation.absoluteFor(precursorMz);
            return this.storage.find(new Filter().and().gte("precursorMz", precursorMz - abs).lte("precursorMz", precursorMz + abs), Ms2SpectralData.class);
        } catch (IOException e) {
            throw new ChemicalDatabaseException(e);
        }
    }

    @Override
    public Iterable<Ms2SpectralMetadata> lookupSpectra(String inchiKey2d) throws ChemicalDatabaseException {
        try {
            return this.storage.find(new Filter().elemMatch(inchiKey2d), Ms2SpectralMetadata.class);
        } catch (IOException e) {
            throw new ChemicalDatabaseException(e);
        }
    }

    @Override
    public Iterable<Ms2SpectralMetadata> getMetaData(Iterable<Ms2SpectralData> data) throws ChemicalDatabaseException {
        try {
            return StreamSupport.stream(data.spliterator(), false).map(d -> {
                try {
                    return storage.getById(d.getMetaId(), Ms2SpectralMetadata.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ChemicalDatabaseException(e);
        }
    }

    @Override
    public Iterable<Ms2SpectralData> getSpectralData(Iterable<Ms2SpectralMetadata> metadata) throws ChemicalDatabaseException {
        try {
            return StreamSupport.stream(metadata.spliterator(), false).map(d -> {
                try {
                    return storage.getById(d.getPeaksId(), Ms2SpectralData.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ChemicalDatabaseException(e);
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tag {
        private String key;
        private String value;

        public static Tag of(String key, String value) {
            return new Tag(key, value);
        }

        public static Tag of(Map.Entry<String, String> source) {
            return of(source.getKey(), source.getValue());
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String setValue(String value) {
            String old = this.value;
            this.value = value;
            return old;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SpectralNoSQLDatabase.Tag tag)) return false;
            return Objects.equals(key, tag.key) && Objects.equals(value, tag.value);
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}

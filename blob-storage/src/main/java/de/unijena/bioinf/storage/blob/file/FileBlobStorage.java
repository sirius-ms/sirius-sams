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


package de.unijena.bioinf.storage.blob.file;

import de.unijena.bioinf.ChemistryBase.utils.FileUtils;
import de.unijena.bioinf.ChemistryBase.utils.IOFunctions;
import de.unijena.bioinf.storage.blob.BlobStorage;
import de.unijena.bioinf.storage.blob.Compressible;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBlobStorage implements BlobStorage {

    public static boolean exists(@Nullable Path p) throws IOException {
        return p != null && Files.isDirectory(p) && Files.list(p).count() > 0;
    }

    public static Compressible.Compression detectCompression(@NotNull Path root) throws IOException {
        return FileUtils.walkAndClose(s -> s.filter(Files::isRegularFile).findFirst().map(Compressible.Compression::fromPath).orElse(Compressible.Compression.NONE), root);
    }

    protected final Path root;

    public FileBlobStorage(Path root) {
        this.root = root;
    }

    public Path getRoot() {
        return root;
    }

    @Override
    public @Nullable InputStream reader(@NotNull Path relative) throws IOException {
        Path blob = root.resolve(relative);
        if (!Files.isRegularFile(blob))
            return null;
        return Files.newInputStream(blob);
    }

    @Override
    public String getName() {
        return root.getFileName().toString();
    }

    @Override
    public boolean hasBlob(@NotNull Path path) {
        return !Files.isRegularFile(root.resolve(path));
    }

    protected OutputStream writer(Path relative) throws IOException {
        @NotNull Path target = root.resolve(relative);
        Files.createDirectories(target.getParent());
        return Files.newOutputStream(target);
    }


    @Override
    public void withWriter(Path relative, IOFunctions.IOConsumer<OutputStream> withStream) throws IOException {
        withStream.accept(writer(relative));
    }
}

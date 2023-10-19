/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schiller University.
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

package de.unijena.bioinf.ms.persistence.model.core;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SourceFile {
    enum Format {
        //todo do we need more info here?
        MZML("Open MzML format"), MZXML("Open MzXML format (Deprecated)"), OTHER("Unknown or unspecified format");

        public final String fullName;

        Format(String fullName) {
            this.fullName = fullName;
        }
    }

    /**
     * Uses the same primary key as {@link Run}
     */

    @Id
    private long runId;

    /**
     * name of this source file
     */
    private String fileName;

    /**
     * File Format, needed for parsing the data if included.
     */
    private Format format;
    /**
     * File contents stored as gzipped byte stream
     */
    private byte[] data;
}

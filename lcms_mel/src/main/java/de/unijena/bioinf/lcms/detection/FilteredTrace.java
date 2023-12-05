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

package de.unijena.bioinf.lcms.detection;

import de.unijena.bioinf.ms.persistence.model.core.Trace;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class FilteredTrace extends Trace {

    private DoubleList filteredIntensities;

    public static FilteredTrace of(Trace trace, DoubleList filteredIntensities) {
        return FilteredTrace.builder()
                .runId(trace.getRunId())
                .scanIds(new LongArrayList(trace.getScanIds()))
                .rts(new DoubleArrayList(trace.getRts()))
                .mzs(new DoubleArrayList(trace.getMzs()))
                .intensities(new DoubleArrayList(trace.getIntensities()))
                .filteredIntensities(filteredIntensities)
                .build();
    }

}

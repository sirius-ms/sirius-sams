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

package de.unijena.bioinf.ms.middleware.model.annotations;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ConsensusAnnotationsCSI extends ConsensusAnnotations {
    public enum Criterion {
        MAJORITY_STRUCTURE,
        CONFIDENCE_STRUCTURE,
        SINGLETON_STRUCTURE,
        MAJORITY_FORMULA,
        TOP_FORMULA,
        SINGLETON_FORMULA
    }


    /**
     * Null if this is a custom selection
     */
    protected Criterion selectionCriterion;

    /**
     * Database structure candidate (searched with CSI:FingerID), that also defines the molecularFormula
     * Might be null if no consensus structure is available.
     */
    protected StructureCandidate csiFingerIdStructure;

    /**
     * Confidence value that represents the certainty that reported consensus structure is exactly the measured one
     * If multiple features support this consensus structure the maximum confidence is reported
     */
    protected Double confidenceExactMatch;

    /**
     * Confidence value that represents the certainty that the exact consensus structure or a very similar
     * structure (e.g. measured by Maximum Common Edge Subgraph Distance) is the measured one.
     * If multiple features support this consensus structure the maximum confidence is reported
     */
    protected Double confidenceApproxMatch;
}

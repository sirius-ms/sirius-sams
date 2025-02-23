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

package de.unijena.bioinf.ms.gui.utils;

import de.unijena.bioinf.ms.gui.configs.Colors;
import org.openscience.cdk.config.Elements;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.renderer.color.CDK2DAtomColors;

import java.awt.*;

public class ThemedAtomColors extends CDK2DAtomColors {

    private Color mainColor;

    public ThemedAtomColors() {
        this(Colors.FOREGROUND_DATA);
    }

    public ThemedAtomColors(Color mainColor) {
        this.mainColor = mainColor;
    }

    @Override
    public Color getAtomColor(IAtom atom) {
        Elements elem = Elements.ofString(atom.getSymbol());
        if (elem == Elements.Hydrogen || elem == Elements.Carbon || elem == Elements.Unknown) {
            return mainColor;
        }
        return super.getAtomColor(atom);
    }
}

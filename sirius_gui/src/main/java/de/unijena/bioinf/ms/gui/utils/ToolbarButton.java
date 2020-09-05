/*
 *  This file is part of the SIRIUS Software for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer, Marvin Meusel and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schilller University.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Affero General Public License
 *  as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with SIRIUS.  If not, see <https://www.gnu.org/licenses/agpl-3.0.txt>
 */

package de.unijena.bioinf.ms.gui.utils;
/**
 * Created by Markus Fleischauer (markus.fleischauer@gmail.com)
 * as part of the sirius_frontend
 * 10.10.16.
 */

import javax.swing.*;
import java.awt.*;

public class ToolbarButton extends JButton {
    public ToolbarButton(String text, Icon icon, String tooltip) {
        super(text, icon);
        configureTButton();
        setToolTipText(tooltip);
    }

    public ToolbarButton(Action action) {
        super(action);
        configureTButton();

    }

    public ToolbarButton(Icon icon) {
        this(null, icon, null);
    }

    public ToolbarButton(Icon icon, String tooltip) {
        this(null, icon, tooltip);
    }

    public ToolbarButton(String text, Icon icon) {
        this(text, icon, null);
    }

    private void configureTButton() {
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setMargin(new Insets(1, 2, 1, 2));
    }
}

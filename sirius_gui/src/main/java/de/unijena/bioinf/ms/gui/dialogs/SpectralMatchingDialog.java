/*
 *  This file is part of the SIRIUS Software for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer, Marvin Meusel and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schiller University.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Affero General Public License
 *  as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License along with SIRIUS.  If not, see <https://www.gnu.org/licenses/agpl-3.0.txt>
 */

package de.unijena.bioinf.ms.gui.dialogs;


import de.unijena.bioinf.ms.gui.fingerid.FingerprintCandidateBean;
import de.unijena.bioinf.ms.gui.mainframe.MainFrame;
import de.unijena.bioinf.ms.gui.mainframe.instance_panel.CompoundList;
import de.unijena.bioinf.ms.gui.mainframe.result_panel.tabs.SpectralMatchingPanel;
import de.unijena.bioinf.ms.gui.ms_viewer.WebViewSpectraViewer;
import de.unijena.bioinf.ms.gui.ms_viewer.data.SpectraJSONWriter;
import de.unijena.bioinf.projectspace.InstanceBean;
import de.unijena.bioinf.projectspace.SpectralSearchResultBean;

import javax.swing.*;
import java.awt.*;

public class SpectralMatchingDialog extends JDialog {

    public SpectralMatchingDialog(final CompoundList compoundList, final FingerprintCandidateBean fingerprintCandidateBean) {
        super(MainFrame.MF, "Reference spectra", true);
        this.setLayout(new BorderLayout());
        this.add(new SpectralMatchingPanel(compoundList, fingerprintCandidateBean), BorderLayout.CENTER);
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setPreferredSize(new Dimension(
                    Math.min(screenSize.width, (int) Math.floor(0.8 * MainFrame.MF.getWidth())),
                    Math.min(screenSize.height, (int) Math.floor(0.8 * MainFrame.MF.getHeight())))
            );
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pack();
            setLocationRelativeTo(getParent());
            setResizable(false);
        }
        super.setVisible(b);
    }

}

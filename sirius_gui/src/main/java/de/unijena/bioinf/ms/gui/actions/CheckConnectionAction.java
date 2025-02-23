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

package de.unijena.bioinf.ms.gui.actions;

import de.unijena.bioinf.ms.gui.SiriusGui;
import de.unijena.bioinf.ms.gui.compute.jjobs.Jobs;
import de.unijena.bioinf.ms.gui.configs.Icons;
import de.unijena.bioinf.ms.gui.net.ConnectionDialog;
import de.unijena.bioinf.ms.gui.net.ConnectionMonitor;
import io.sirius.ms.sdk.model.ConnectionCheck;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static de.unijena.bioinf.ms.gui.net.ConnectionChecks.isConnected;
import static de.unijena.bioinf.ms.gui.net.ConnectionChecks.isWarningOnly;

/**
 * THREAD SAFE
 */
public class CheckConnectionAction extends AbstractGuiAction implements PropertyChangeListener {

    protected CheckConnectionAction(SiriusGui gui) {
        super("Webservice", gui);
        putValue(Action.SHORT_DESCRIPTION, "Check and refresh webservice connection");
        gui.getConnectionMonitor().addConnectionStateListener(this);
        Jobs.runInBackground(() -> setIcon(this.gui.getConnectionMonitor().checkConnection()));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ConnectionDialog.of(gui);
        } catch (Exception e1) {
            LoggerFactory.getLogger(getClass()).error("Error when checking connection by action", e1);
        }
    }


    public static ConnectionCheck checkConnectionAndLoad(SiriusGui gui) {
        return Jobs.runInBackgroundAndLoad(gui.getMainFrame(), "Checking connection...",
                () -> gui.getConnectionMonitor().checkConnection()).getResult();
    }

    protected void setIcon(final @Nullable ConnectionCheck check) {
        Jobs.runEDTLater(() -> {
            if (check != null) {
                if (isConnected(check))
                    putValue(Action.LARGE_ICON_KEY, Icons.NET_YES.derive(32, 32));
                else if (isWarningOnly(check))
                    putValue(Action.LARGE_ICON_KEY, Icons.NET_WARN.derive(32, 32));
                else
                    putValue(Action.LARGE_ICON_KEY, Icons.NET_NO.derive(32, 32));
            }
        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setIcon(((ConnectionMonitor.ConnectionStateEvent) evt).getConnectionCheck());
    }
}

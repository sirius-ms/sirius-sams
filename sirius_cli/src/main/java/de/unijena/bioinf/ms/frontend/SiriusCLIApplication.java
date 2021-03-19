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

package de.unijena.bioinf.ms.frontend;

import de.unijena.bioinf.jjobs.JobManager;
import de.unijena.bioinf.ms.annotations.PrintCitations;
import de.unijena.bioinf.ms.frontend.core.ApplicationCore;
import de.unijena.bioinf.ms.frontend.subtools.CLIRootOptions;
import de.unijena.bioinf.ms.frontend.subtools.config.DefaultParameterConfigLoader;
import de.unijena.bioinf.ms.frontend.workflow.SimpleInstanceBuffer;
import de.unijena.bioinf.ms.frontend.workflow.WorkFlowSupplier;
import de.unijena.bioinf.ms.frontend.workflow.WorkflowBuilder;
import de.unijena.bioinf.ms.properties.PropertyManager;
import de.unijena.bioinf.projectspace.ProjectSpaceManagerFactory;
import de.unijena.bioinf.webapi.ProxyManager;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.stream.Stream;


public class SiriusCLIApplication {
    protected static Run RUN = null;
    protected static boolean successfulParsed;

    protected static final boolean TIME = false;
    protected static long t1;

    public static void main(String[] args) {
        if (TIME)
            t1 = System.currentTimeMillis();
        try {
            configureShutDownHook(shutdownWebservice());
            measureTime("Start Run method");
            run(args, () -> {
                final DefaultParameterConfigLoader configOptionLoader = new DefaultParameterConfigLoader();
                return new WorkflowBuilder<>(new CLIRootOptions<>(configOptionLoader, new ProjectSpaceManagerFactory.Default()), configOptionLoader, new SimpleInstanceBuffer.Factory());
            });
        } finally {
            System.exit(0);
        }
    }

    public static void measureTime(String message){
        if (TIME) {
            long t2 = System.currentTimeMillis();
            System.err.println("==> " + message + " - " + (t2 - t1) / 1000d);
            t1 = t2;
        }
    }

    public static void configureShutDownHook(@NotNull final Runnable... additionalActions) {
        //shut down hook to clean up when sirius is shutting down
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ApplicationCore.DEFAULT_LOGGER.info("CLI shut down hook: SIRIUS is cleaning up threads and shuts down...");
            try {
                if (SiriusCLIApplication.RUN != null)
                    SiriusCLIApplication.RUN.cancel();
                Stream.of(additionalActions).forEach(Runnable::run);
                JobManager.shutDownNowAllInstances();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ProxyManager.disconnect();
                if (successfulParsed && PropertyManager.DEFAULTS.createInstanceWithDefaults(PrintCitations.class).value)
                    ApplicationCore.BIBTEX.citeToSystemErr();
            }
        }));
    }

    public static Runnable shutdownWebservice() {
        return () -> {
            try {
                ApplicationCore.WEB_API.shutdownJobWatcher();
                ApplicationCore.DEFAULT_LOGGER.info("Try to delete leftover jobs on web server...");
                ApplicationCore.WEB_API.deleteClientAndJobs();
                ApplicationCore.DEFAULT_LOGGER.info("...Job deletion Done!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void run(String[] args, WorkFlowSupplier supplier) {
        try {
            if (RUN != null)
                throw new IllegalStateException("Aplication can only run Once!");
            measureTime("init Run");
            RUN = new Run(supplier.make());
            measureTime("Start Parse args");
            successfulParsed = RUN.parseArgs(args);
            measureTime("Parse args Done!");
            if (successfulParsed){
                measureTime("Compute");
                RUN.compute();
                measureTime("Compute DONE!");
            }
        } catch (Throwable e) {
            LoggerFactory.getLogger(SiriusCLIApplication.class).error("Unexpected Error!", e);
        }
    }
}

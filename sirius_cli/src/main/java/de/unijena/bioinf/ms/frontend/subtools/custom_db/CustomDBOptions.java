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

package de.unijena.bioinf.ms.frontend.subtools.custom_db;

import de.unijena.bioinf.chemdb.DataSource;
import de.unijena.bioinf.chemdb.SearchableDatabases;
import de.unijena.bioinf.chemdb.custom.CustomDatabaseImporter;
import de.unijena.bioinf.ms.frontend.core.ApplicationCore;
import de.unijena.bioinf.ms.frontend.subtools.InputFilesOptions;
import de.unijena.bioinf.ms.frontend.subtools.Provide;
import de.unijena.bioinf.ms.frontend.subtools.RootOptions;
import de.unijena.bioinf.ms.frontend.subtools.StandaloneTool;
import de.unijena.bioinf.ms.frontend.workflow.Workflow;
import de.unijena.bioinf.ms.properties.ParameterConfig;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * This is for parameters needed to create a custom DB.
 *
 * @author Markus Fleischauer (markus.fleischauer@gmail.com)
 */
@CommandLine.Command(name = "custom-db", aliases = {"DB"}, description = "<STANDALONE> Generate a custom searchable structure database. Import multiple files with compounds as SMILES or InChi into this DB.", versionProvider = Provide.Versions.class, mixinStandardHelpOptions = true, showDefaultValues = true)
public class CustomDBOptions implements StandaloneTool<Workflow> {

    @Option(names = "--name", required = true,
            description = {"Name of the custom database. It will be stored at in ('$USER_HOME/.sirius/csi_fingerid_cache/custom') or the specified sirius workspace (--workspace)."})
    public String dbName;

    @Option(names = "--output",
            description = {"Alternative output directory of the custom database. The db will be a sub directory with the given name (--name).", "Default: '$USER_HOME/.sirius/csi_fingerid_cache/custom'"})
    public Path outputDir = null;

    @Option(names = {"--buffer-size", "--buffer"}, defaultValue = "1000",
            description = {"Maximum number of downloaded/computed compounds to keep in memory before writing them to disk (into the db directory)."})
    public int writeBuffer;

    @Option(names = {"--derive-from"}, split = ",",
            description = {"The resulting custom-db will be the Union of the given parent database and the imported structures."})
    public EnumSet<DataSource> parentDBs = null;

    @Override
    public Workflow makeWorkflow(RootOptions<?, ?, ?> rootOptions, ParameterConfig config) {
        return () -> {

            final InputFilesOptions input = rootOptions.getInput();
            if (dbName == null || dbName.isEmpty() || input == null || input.msInput == null || input.msInput.unknownFiles.isEmpty()) {
                LoggerFactory.getLogger(CustomDatabaseImporter.class).error("No input data given. Do nothing");
                return;
            }
            try {
                Path loc = outputDir != null ? outputDir : SearchableDatabases.getCustomDatabaseDirectory().toPath();
                Files.createDirectories(loc);
                CustomDatabaseImporter.importDatabase(loc.resolve(dbName).toFile(),
                        input.msInput.unknownFiles.stream().map(Path::toFile).collect(Collectors.toList()),
                        parentDBs,
                        ApplicationCore.WEB_API, writeBuffer);
                LoggerFactory.getLogger(CustomDatabaseImporter.class).info("Database imported. Use 'structure --db=\"" + loc.toString() + "\"' to search in this database.");
            } catch (IOException e) {
                LoggerFactory.getLogger(CustomDatabaseImporter.class).error("error when storing custom db");
            }
        };
    }
}

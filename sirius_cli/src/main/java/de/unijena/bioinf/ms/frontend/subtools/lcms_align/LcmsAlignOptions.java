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

package de.unijena.bioinf.ms.frontend.subtools.lcms_align;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.unijena.bioinf.ChemistryBase.ms.lcms.workflows.LCMSWorkflow;
import de.unijena.bioinf.ms.frontend.subtools.PreprocessingTool;
import de.unijena.bioinf.ms.frontend.subtools.Provide;
import de.unijena.bioinf.ms.frontend.subtools.RootOptions;
import de.unijena.bioinf.ms.properties.ParameterConfig;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@CommandLine.Command(name = "lcms-align", aliases = {"A"}, description = "<PREPROCESSING> Align and merge compounds of multiple LCMS Runs. Use this tool if you want to import from mzML/mzXml", versionProvider = Provide.Versions.class, mixinStandardHelpOptions = true, showDefaultValues = true)
public class LcmsAlignOptions implements PreprocessingTool<LcmsAlignSubToolJob> {

    @Override
    public LcmsAlignSubToolJob makePreprocessingJob(RootOptions<?,?,?> rootOptions, ParameterConfig config) {
        return new LcmsAlignSubToolJob(rootOptions.getInput(), rootOptions.getProjectSpace(), this);
    }

    protected Optional<LCMSWorkflow> workflow = Optional.empty();

    public Optional<LCMSWorkflow> getWorkflow() {
        return workflow;
    }

    @CommandLine.Option(names = {"--workflow","-w"})
    public void setWorkflow(File filename) {
        if (filename==null) {
            this.workflow = Optional.empty();
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.workflow = Optional.of(mapper.readValue(filename, LCMSWorkflow.class));
        } catch (IOException e) {
            LoggerFactory.getLogger(LcmsAlignOptions.class).error(e.getMessage(), e);
            throw new RuntimeException("Cancel workflow");

        }
    }
}


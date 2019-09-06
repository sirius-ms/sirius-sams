package de.unijena.bioinf.projectspace.fingerid;

import de.unijena.bioinf.ChemistryBase.fp.Fingerprint;
import de.unijena.bioinf.ChemistryBase.fp.ProbabilityFingerprint;
import de.unijena.bioinf.fingerid.CanopusResult;
import de.unijena.bioinf.fingerid.FingerprintResult;
import de.unijena.bioinf.projectspace.*;
import de.unijena.bioinf.projectspace.sirius.FormulaResult;

import java.io.IOException;

public class FingerprintSerializer implements ComponentSerializer<FormulaResultId, FormulaResult, FingerprintResult> {

    @Override
    public FingerprintResult read(ProjectReader reader, FormulaResultId id, FormulaResult container) throws IOException {
        String loc = FingerIdLocations.FingerprintDir + "/" + id.fileName("fpt");
        if (!reader.exists(loc)) return null;
        final CSIClientData csiClientData = reader.getProjectSpaceProperty(CSIClientData.class);
        final double[] probabilities = reader.doubleVector(loc);
        return new FingerprintResult(new ProbabilityFingerprint(csiClientData.getFingerprintVersion(), probabilities));
    }

    @Override
    public void write(ProjectWriter writer, FormulaResultId id, FormulaResult container, FingerprintResult component) throws IOException {
        writer.inDirectory(FingerIdLocations.FingerprintDir, ()->{
            writer.doubleVector(id.fileName("fpt"), component.fingerprint.toProbabilityArray());
            return true;
        });
    }

    @Override
    public void delete(ProjectWriter writer, FormulaResultId id) throws IOException {
        writer.delete(FingerIdLocations.FingerprintDir + "/" + id.fileName("fpt"));
    }
}

package de.unijena.bioinf.ms.rest.model.canopus;

import de.unijena.bioinf.ms.rest.model.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CanopusJob extends Job<CanopusJobOutput> {
    protected byte[] fingerprint; // LITTLE ENDIAN BINARY ENCODED PLATT PROBABILITIES
    protected byte[] compoundClasses; // LITTLE ENDIAN BINARY ENCODED PLATT PROBABILITIES

    public CanopusJob() {
        this(null, null, null);
    }

    public CanopusJob(String workerPrefix, String ip, String cid, @NotNull CanopusJobInput input) {
        this(workerPrefix, JobState.SUBMITTED);
        setIp(ip);
        setCid(cid);
        setFingerprint(input.fingerprint);
    }

    public CanopusJob(String workerPrefix, JobState state) {
        this(workerPrefix, null, state);
    }

    public CanopusJob(String workerPrefix, Long jobId, JobState state) {
        super(workerPrefix, jobId, state, JobTable.JOBS_CANOPUS);
    }

    public byte[] getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(byte[] fingerprint) {
        this.fingerprint = fingerprint;
    }

    public byte[] getCompoundClasses() {
        return compoundClasses;
    }

    public void setCompoundClasses(byte[] compoundClasses) {
        this.compoundClasses = compoundClasses;
    }


    @Override
    @Nullable
    public CanopusJobOutput extractOutput() {
        return compoundClasses != null ? new CanopusJobOutput(compoundClasses) : null;
    }



/*
    @Override
    public void setOutput(CanopusJobOutput output) {
        setCompoundClasses(output.compoundClasses);
    }

    @Override
    public CanopusJobInput asInput() {
        return new CanopusJobInput(fingerprint);
    }

    @Override
    public void setIntput(CanopusJobInput input) {
        setFingerprint(input.fingerprint);
    }*/
}


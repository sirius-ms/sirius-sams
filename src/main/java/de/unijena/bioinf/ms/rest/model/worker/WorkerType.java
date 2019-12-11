package de.unijena.bioinf.ms.rest.model.worker;

import de.unijena.bioinf.ms.rest.model.JobTable;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.stream.Collectors;

//specifies job from which jobtable a worker has to use see @JobTable
public enum WorkerType {
    FORMULA_ID(EnumSet.of(JobTable.TREE_JOB)),
    FINGER_ID(EnumSet.of(JobTable.SIRIUS_FINGERID_JOB, JobTable.FINGERPRINT_JOB)),
    CANOPUS(EnumSet.of(JobTable.SIRIUS_FINGERID_JOB, JobTable.FINGERPRINT_JOB)),
    GUARDIAN(null);


    private final EnumSet<JobTable> jobTables;

    WorkerType(EnumSet<JobTable> jobTableNames) {
        jobTables = jobTableNames;
    }

    public EnumSet<JobTable> jobTables() {
        return jobTables;
    }

    //todo can we do this generic for all type enums
    public static EnumSet<WorkerType> parse(@NotNull String workerTypes, String regexDelimiter) {
        return Arrays.stream(workerTypes.split(regexDelimiter))
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter((s) -> !s.isEmpty())
                .map(WorkerType::valueOf)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(WorkerType.class)));
    }

    public static EnumSet<WorkerType> parse(@NotNull String workerTypes) {
        return parse(workerTypes, ",");
    }
}

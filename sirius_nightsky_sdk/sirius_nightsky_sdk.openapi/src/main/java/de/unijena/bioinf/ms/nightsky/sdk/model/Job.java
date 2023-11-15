/*
 * SIRIUS Nightsky API
 * REST API that provides the full functionality of SIRIUS and its web services as background service. It is intended as entry-point for scripting languages and software integration SDKs.This API is exposed by SIRIUS 6.0.0-SNAPSHOT
 *
 * The version of the OpenAPI document: 2.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.unijena.bioinf.ms.nightsky.sdk.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import de.unijena.bioinf.ms.nightsky.sdk.model.JobProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Identifier created by the SIRIUS Nightsky API for a newly created Job.  Object can be enriched with Job status/progress information ({@link JobProgress JobProgress}) and/or Job command information.
 */
@JsonPropertyOrder({
  Job.JSON_PROPERTY_ID,
  Job.JSON_PROPERTY_COMMAND,
  Job.JSON_PROPERTY_PROGRESS,
  Job.JSON_PROPERTY_AFFECTED_COMPOUND_IDS,
  Job.JSON_PROPERTY_AFFECTED_ALIGNED_FEATURE_IDS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Job {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_COMMAND = "command";
  private String command;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  private JobProgress progress;

  public static final String JSON_PROPERTY_AFFECTED_COMPOUND_IDS = "affectedCompoundIds";
  private List<String> affectedCompoundIds;

  public static final String JSON_PROPERTY_AFFECTED_ALIGNED_FEATURE_IDS = "affectedAlignedFeatureIds";
  private List<String> affectedAlignedFeatureIds;

  public Job() { 
  }

  public Job id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier to access the job via the API
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public Job command(String command) {
    this.command = command;
    return this;
  }

   /**
   * Command string of the executed Task
   * @return command
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCommand() {
    return command;
  }


  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCommand(String command) {
    this.command = command;
  }


  public Job progress(JobProgress progress) {
    this.progress = progress;
    return this;
  }

   /**
   * Get progress
   * @return progress
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JobProgress getProgress() {
    return progress;
  }


  @JsonProperty(JSON_PROPERTY_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProgress(JobProgress progress) {
    this.progress = progress;
  }


  public Job affectedCompoundIds(List<String> affectedCompoundIds) {
    this.affectedCompoundIds = affectedCompoundIds;
    return this;
  }

  public Job addAffectedCompoundIdsItem(String affectedCompoundIdsItem) {
    if (this.affectedCompoundIds == null) {
      this.affectedCompoundIds = new ArrayList<>();
    }
    this.affectedCompoundIds.add(affectedCompoundIdsItem);
    return this;
  }

   /**
   * List of compoundIds that are affected by this job.  This lis will also contain compoundIds where not all features of the compound are affected by the job.  If this job is creating compounds (e.g. data import jobs) this value will be NULL until the jobs has finished
   * @return affectedCompoundIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AFFECTED_COMPOUND_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAffectedCompoundIds() {
    return affectedCompoundIds;
  }


  @JsonProperty(JSON_PROPERTY_AFFECTED_COMPOUND_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAffectedCompoundIds(List<String> affectedCompoundIds) {
    this.affectedCompoundIds = affectedCompoundIds;
  }


  public Job affectedAlignedFeatureIds(List<String> affectedAlignedFeatureIds) {
    this.affectedAlignedFeatureIds = affectedAlignedFeatureIds;
    return this;
  }

  public Job addAffectedAlignedFeatureIdsItem(String affectedAlignedFeatureIdsItem) {
    if (this.affectedAlignedFeatureIds == null) {
      this.affectedAlignedFeatureIds = new ArrayList<>();
    }
    this.affectedAlignedFeatureIds.add(affectedAlignedFeatureIdsItem);
    return this;
  }

   /**
   * List of alignedFeatureIds that are affected by this job.  If this job is creating features (e.g. data import jobs) this value will be NULL until the jobs has finished
   * @return affectedAlignedFeatureIds
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AFFECTED_ALIGNED_FEATURE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAffectedAlignedFeatureIds() {
    return affectedAlignedFeatureIds;
  }


  @JsonProperty(JSON_PROPERTY_AFFECTED_ALIGNED_FEATURE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAffectedAlignedFeatureIds(List<String> affectedAlignedFeatureIds) {
    this.affectedAlignedFeatureIds = affectedAlignedFeatureIds;
  }


  /**
   * Return true if this Job object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Job job = (Job) o;
    return Objects.equals(this.id, job.id) &&
        Objects.equals(this.command, job.command) &&
        Objects.equals(this.progress, job.progress) &&
        Objects.equals(this.affectedCompoundIds, job.affectedCompoundIds) &&
        Objects.equals(this.affectedAlignedFeatureIds, job.affectedAlignedFeatureIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, command, progress, affectedCompoundIds, affectedAlignedFeatureIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Job {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    affectedCompoundIds: ").append(toIndentedString(affectedCompoundIds)).append("\n");
    sb.append("    affectedAlignedFeatureIds: ").append(toIndentedString(affectedAlignedFeatureIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `id` to the URL query string
    if (getId() != null) {
      joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `command` to the URL query string
    if (getCommand() != null) {
      joiner.add(String.format("%scommand%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCommand()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `progress` to the URL query string
    if (getProgress() != null) {
      joiner.add(getProgress().toUrlQueryString(prefix + "progress" + suffix));
    }

    // add `affectedCompoundIds` to the URL query string
    if (getAffectedCompoundIds() != null) {
      for (int i = 0; i < getAffectedCompoundIds().size(); i++) {
        joiner.add(String.format("%saffectedCompoundIds%s%s=%s", prefix, suffix,
            "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
            URLEncoder.encode(String.valueOf(getAffectedCompoundIds().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
      }
    }

    // add `affectedAlignedFeatureIds` to the URL query string
    if (getAffectedAlignedFeatureIds() != null) {
      for (int i = 0; i < getAffectedAlignedFeatureIds().size(); i++) {
        joiner.add(String.format("%saffectedAlignedFeatureIds%s%s=%s", prefix, suffix,
            "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
            URLEncoder.encode(String.valueOf(getAffectedAlignedFeatureIds().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
      }
    }

    return joiner.toString();
  }
}


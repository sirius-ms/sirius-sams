/*
 *  This file is part of the SIRIUS libraries for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2024 Bright Giant GmbH
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with SIRIUS.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 *  https://openapi-generator.tech
 *  Do not edit the class manually.
 */


package io.sirius.ms.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SampleTypeFoldChangeRequest
 */
@JsonPropertyOrder({
  SampleTypeFoldChangeRequest.JSON_PROPERTY_SAMPLE_RUN_IDS,
  SampleTypeFoldChangeRequest.JSON_PROPERTY_BLANK_RUN_IDS,
  SampleTypeFoldChangeRequest.JSON_PROPERTY_CONTROL_RUN_IDS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class SampleTypeFoldChangeRequest {
  public static final String JSON_PROPERTY_SAMPLE_RUN_IDS = "sampleRunIds";
  private List<String> sampleRunIds = new ArrayList<>();

  public static final String JSON_PROPERTY_BLANK_RUN_IDS = "blankRunIds";
  private List<String> blankRunIds = new ArrayList<>();

  public static final String JSON_PROPERTY_CONTROL_RUN_IDS = "controlRunIds";
  private List<String> controlRunIds = new ArrayList<>();

  public SampleTypeFoldChangeRequest() {
  }

  public SampleTypeFoldChangeRequest sampleRunIds(List<String> sampleRunIds) {
    
    this.sampleRunIds = sampleRunIds;
    return this;
  }

  public SampleTypeFoldChangeRequest addSampleRunIdsItem(String sampleRunIdsItem) {
    if (this.sampleRunIds == null) {
      this.sampleRunIds = new ArrayList<>();
    }
    this.sampleRunIds.add(sampleRunIdsItem);
    return this;
  }

   /**
   * Get sampleRunIds
   * @return sampleRunIds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SAMPLE_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getSampleRunIds() {
    return sampleRunIds;
  }


  @JsonProperty(JSON_PROPERTY_SAMPLE_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSampleRunIds(List<String> sampleRunIds) {
    this.sampleRunIds = sampleRunIds;
  }

  public SampleTypeFoldChangeRequest blankRunIds(List<String> blankRunIds) {
    
    this.blankRunIds = blankRunIds;
    return this;
  }

  public SampleTypeFoldChangeRequest addBlankRunIdsItem(String blankRunIdsItem) {
    if (this.blankRunIds == null) {
      this.blankRunIds = new ArrayList<>();
    }
    this.blankRunIds.add(blankRunIdsItem);
    return this;
  }

   /**
   * Get blankRunIds
   * @return blankRunIds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_BLANK_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getBlankRunIds() {
    return blankRunIds;
  }


  @JsonProperty(JSON_PROPERTY_BLANK_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBlankRunIds(List<String> blankRunIds) {
    this.blankRunIds = blankRunIds;
  }

  public SampleTypeFoldChangeRequest controlRunIds(List<String> controlRunIds) {
    
    this.controlRunIds = controlRunIds;
    return this;
  }

  public SampleTypeFoldChangeRequest addControlRunIdsItem(String controlRunIdsItem) {
    if (this.controlRunIds == null) {
      this.controlRunIds = new ArrayList<>();
    }
    this.controlRunIds.add(controlRunIdsItem);
    return this;
  }

   /**
   * Get controlRunIds
   * @return controlRunIds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTROL_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getControlRunIds() {
    return controlRunIds;
  }


  @JsonProperty(JSON_PROPERTY_CONTROL_RUN_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setControlRunIds(List<String> controlRunIds) {
    this.controlRunIds = controlRunIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleTypeFoldChangeRequest sampleTypeFoldChangeRequest = (SampleTypeFoldChangeRequest) o;
    return Objects.equals(this.sampleRunIds, sampleTypeFoldChangeRequest.sampleRunIds) &&
        Objects.equals(this.blankRunIds, sampleTypeFoldChangeRequest.blankRunIds) &&
        Objects.equals(this.controlRunIds, sampleTypeFoldChangeRequest.controlRunIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sampleRunIds, blankRunIds, controlRunIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleTypeFoldChangeRequest {\n");
    sb.append("    sampleRunIds: ").append(toIndentedString(sampleRunIds)).append("\n");
    sb.append("    blankRunIds: ").append(toIndentedString(blankRunIds)).append("\n");
    sb.append("    controlRunIds: ").append(toIndentedString(controlRunIds)).append("\n");
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

}


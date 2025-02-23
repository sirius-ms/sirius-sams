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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * User/developer friendly parameter subset for the CSI:FingerID Fingerprint tool  Needs results from Formula/SIRIUS Tool
 */
@JsonPropertyOrder({
  FingerprintPrediction.JSON_PROPERTY_ENABLED,
  FingerprintPrediction.JSON_PROPERTY_USE_SCORE_THRESHOLD,
  FingerprintPrediction.JSON_PROPERTY_ALWAYS_PREDICT_HIGH_REF_MATCHES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class FingerprintPrediction {
  public static final String JSON_PROPERTY_ENABLED = "enabled";
  private Boolean enabled;

  public static final String JSON_PROPERTY_USE_SCORE_THRESHOLD = "useScoreThreshold";
  private Boolean useScoreThreshold;

  public static final String JSON_PROPERTY_ALWAYS_PREDICT_HIGH_REF_MATCHES = "alwaysPredictHighRefMatches";
  private Boolean alwaysPredictHighRefMatches;

  public FingerprintPrediction() {
  }

  public FingerprintPrediction enabled(Boolean enabled) {
    
    this.enabled = enabled;
    return this;
  }

   /**
   * tags whether the tool is enabled
   * @return enabled
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isEnabled() {
    return enabled;
  }


  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public FingerprintPrediction useScoreThreshold(Boolean useScoreThreshold) {
    
    this.useScoreThreshold = useScoreThreshold;
    return this;
  }

   /**
   * If true, an adaptive soft threshold will be applied to only compute Fingerprints for promising formula candidates  Enabling is highly recommended.
   * @return useScoreThreshold
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USE_SCORE_THRESHOLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isUseScoreThreshold() {
    return useScoreThreshold;
  }


  @JsonProperty(JSON_PROPERTY_USE_SCORE_THRESHOLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUseScoreThreshold(Boolean useScoreThreshold) {
    this.useScoreThreshold = useScoreThreshold;
  }

  public FingerprintPrediction alwaysPredictHighRefMatches(Boolean alwaysPredictHighRefMatches) {
    
    this.alwaysPredictHighRefMatches = alwaysPredictHighRefMatches;
    return this;
  }

   /**
   * If true Fingerprint/Classes/Structures will be predicted for formulas candidates with  reference spectrum similarity &gt; Sirius.minReferenceMatchScoreToInject will be predicted no matter which  score threshold rules apply.  If NULL default value will be used.
   * @return alwaysPredictHighRefMatches
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ALWAYS_PREDICT_HIGH_REF_MATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isAlwaysPredictHighRefMatches() {
    return alwaysPredictHighRefMatches;
  }


  @JsonProperty(JSON_PROPERTY_ALWAYS_PREDICT_HIGH_REF_MATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAlwaysPredictHighRefMatches(Boolean alwaysPredictHighRefMatches) {
    this.alwaysPredictHighRefMatches = alwaysPredictHighRefMatches;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FingerprintPrediction fingerprintPrediction = (FingerprintPrediction) o;
    return Objects.equals(this.enabled, fingerprintPrediction.enabled) &&
        Objects.equals(this.useScoreThreshold, fingerprintPrediction.useScoreThreshold) &&
        Objects.equals(this.alwaysPredictHighRefMatches, fingerprintPrediction.alwaysPredictHighRefMatches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, useScoreThreshold, alwaysPredictHighRefMatches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FingerprintPrediction {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    useScoreThreshold: ").append(toIndentedString(useScoreThreshold)).append("\n");
    sb.append("    alwaysPredictHighRefMatches: ").append(toIndentedString(alwaysPredictHighRefMatches)).append("\n");
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


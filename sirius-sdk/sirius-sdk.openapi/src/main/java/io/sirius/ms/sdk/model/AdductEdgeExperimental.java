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
 * EXPERIMENTAL: This schema is experimental and may be changed (or even removed) without notice until it is declared stable.
 */
@JsonPropertyOrder({
  AdductEdgeExperimental.JSON_PROPERTY_MZ_DELTA,
  AdductEdgeExperimental.JSON_PROPERTY_ANNOTATION,
  AdductEdgeExperimental.JSON_PROPERTY_FROM,
  AdductEdgeExperimental.JSON_PROPERTY_TO,
  AdductEdgeExperimental.JSON_PROPERTY_MERGED_CORRELATION,
  AdductEdgeExperimental.JSON_PROPERTY_REPRESENTATIVE_CORRELATION,
  AdductEdgeExperimental.JSON_PROPERTY_MS2COSINE,
  AdductEdgeExperimental.JSON_PROPERTY_PVALUE,
  AdductEdgeExperimental.JSON_PROPERTY_INTENSITY_RATIO_SCORE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class AdductEdgeExperimental {
  public static final String JSON_PROPERTY_MZ_DELTA = "mzDelta";
  private Double mzDelta;

  public static final String JSON_PROPERTY_ANNOTATION = "annotation";
  private String annotation;

  public static final String JSON_PROPERTY_FROM = "from";
  private Integer from;

  public static final String JSON_PROPERTY_TO = "to";
  private Integer to;

  public static final String JSON_PROPERTY_MERGED_CORRELATION = "mergedCorrelation";
  private Float mergedCorrelation;

  public static final String JSON_PROPERTY_REPRESENTATIVE_CORRELATION = "representativeCorrelation";
  private Float representativeCorrelation;

  public static final String JSON_PROPERTY_MS2COSINE = "ms2cosine";
  private Float ms2cosine;

  public static final String JSON_PROPERTY_PVALUE = "pvalue";
  private Float pvalue;

  public static final String JSON_PROPERTY_INTENSITY_RATIO_SCORE = "intensityRatioScore";
  private Float intensityRatioScore;

  public AdductEdgeExperimental() {
  }

  public AdductEdgeExperimental mzDelta(Double mzDelta) {
    
    this.mzDelta = mzDelta;
    return this;
  }

   /**
   * Get mzDelta
   * @return mzDelta
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MZ_DELTA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMzDelta() {
    return mzDelta;
  }


  @JsonProperty(JSON_PROPERTY_MZ_DELTA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMzDelta(Double mzDelta) {
    this.mzDelta = mzDelta;
  }

  public AdductEdgeExperimental annotation(String annotation) {
    
    this.annotation = annotation;
    return this;
  }

   /**
   * Get annotation
   * @return annotation
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ANNOTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAnnotation() {
    return annotation;
  }


  @JsonProperty(JSON_PROPERTY_ANNOTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public AdductEdgeExperimental from(Integer from) {
    
    this.from = from;
    return this;
  }

   /**
   * Get from
   * @return from
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getFrom() {
    return from;
  }


  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrom(Integer from) {
    this.from = from;
  }

  public AdductEdgeExperimental to(Integer to) {
    
    this.to = to;
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTo() {
    return to;
  }


  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTo(Integer to) {
    this.to = to;
  }

  public AdductEdgeExperimental mergedCorrelation(Float mergedCorrelation) {
    
    this.mergedCorrelation = mergedCorrelation;
    return this;
  }

   /**
   * Get mergedCorrelation
   * @return mergedCorrelation
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MERGED_CORRELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Float getMergedCorrelation() {
    return mergedCorrelation;
  }


  @JsonProperty(JSON_PROPERTY_MERGED_CORRELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMergedCorrelation(Float mergedCorrelation) {
    this.mergedCorrelation = mergedCorrelation;
  }

  public AdductEdgeExperimental representativeCorrelation(Float representativeCorrelation) {
    
    this.representativeCorrelation = representativeCorrelation;
    return this;
  }

   /**
   * Get representativeCorrelation
   * @return representativeCorrelation
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REPRESENTATIVE_CORRELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Float getRepresentativeCorrelation() {
    return representativeCorrelation;
  }


  @JsonProperty(JSON_PROPERTY_REPRESENTATIVE_CORRELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRepresentativeCorrelation(Float representativeCorrelation) {
    this.representativeCorrelation = representativeCorrelation;
  }

  public AdductEdgeExperimental ms2cosine(Float ms2cosine) {
    
    this.ms2cosine = ms2cosine;
    return this;
  }

   /**
   * Get ms2cosine
   * @return ms2cosine
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MS2COSINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Float getMs2cosine() {
    return ms2cosine;
  }


  @JsonProperty(JSON_PROPERTY_MS2COSINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMs2cosine(Float ms2cosine) {
    this.ms2cosine = ms2cosine;
  }

  public AdductEdgeExperimental pvalue(Float pvalue) {
    
    this.pvalue = pvalue;
    return this;
  }

   /**
   * Get pvalue
   * @return pvalue
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PVALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Float getPvalue() {
    return pvalue;
  }


  @JsonProperty(JSON_PROPERTY_PVALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPvalue(Float pvalue) {
    this.pvalue = pvalue;
  }

  public AdductEdgeExperimental intensityRatioScore(Float intensityRatioScore) {
    
    this.intensityRatioScore = intensityRatioScore;
    return this;
  }

   /**
   * Get intensityRatioScore
   * @return intensityRatioScore
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INTENSITY_RATIO_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Float getIntensityRatioScore() {
    return intensityRatioScore;
  }


  @JsonProperty(JSON_PROPERTY_INTENSITY_RATIO_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIntensityRatioScore(Float intensityRatioScore) {
    this.intensityRatioScore = intensityRatioScore;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdductEdgeExperimental adductEdgeExperimental = (AdductEdgeExperimental) o;
    return Objects.equals(this.mzDelta, adductEdgeExperimental.mzDelta) &&
        Objects.equals(this.annotation, adductEdgeExperimental.annotation) &&
        Objects.equals(this.from, adductEdgeExperimental.from) &&
        Objects.equals(this.to, adductEdgeExperimental.to) &&
        Objects.equals(this.mergedCorrelation, adductEdgeExperimental.mergedCorrelation) &&
        Objects.equals(this.representativeCorrelation, adductEdgeExperimental.representativeCorrelation) &&
        Objects.equals(this.ms2cosine, adductEdgeExperimental.ms2cosine) &&
        Objects.equals(this.pvalue, adductEdgeExperimental.pvalue) &&
        Objects.equals(this.intensityRatioScore, adductEdgeExperimental.intensityRatioScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mzDelta, annotation, from, to, mergedCorrelation, representativeCorrelation, ms2cosine, pvalue, intensityRatioScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdductEdgeExperimental {\n");
    sb.append("    mzDelta: ").append(toIndentedString(mzDelta)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    mergedCorrelation: ").append(toIndentedString(mergedCorrelation)).append("\n");
    sb.append("    representativeCorrelation: ").append(toIndentedString(representativeCorrelation)).append("\n");
    sb.append("    ms2cosine: ").append(toIndentedString(ms2cosine)).append("\n");
    sb.append("    pvalue: ").append(toIndentedString(pvalue)).append("\n");
    sb.append("    intensityRatioScore: ").append(toIndentedString(intensityRatioScore)).append("\n");
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


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
 * LossEdge
 */
@JsonPropertyOrder({
  LossEdge.JSON_PROPERTY_SOURCE_FRAGMENT_IDX,
  LossEdge.JSON_PROPERTY_TARGET_FRAGMENT_IDX,
  LossEdge.JSON_PROPERTY_MOLECULAR_FORMULA,
  LossEdge.JSON_PROPERTY_SCORE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class LossEdge {
  public static final String JSON_PROPERTY_SOURCE_FRAGMENT_IDX = "sourceFragmentIdx";
  private Integer sourceFragmentIdx;

  public static final String JSON_PROPERTY_TARGET_FRAGMENT_IDX = "targetFragmentIdx";
  private Integer targetFragmentIdx;

  public static final String JSON_PROPERTY_MOLECULAR_FORMULA = "molecularFormula";
  private String molecularFormula;

  public static final String JSON_PROPERTY_SCORE = "score";
  private Double score;

  public LossEdge() {
  }

  public LossEdge sourceFragmentIdx(Integer sourceFragmentIdx) {
    
    this.sourceFragmentIdx = sourceFragmentIdx;
    return this;
  }

   /**
   * Get sourceFragmentIdx
   * @return sourceFragmentIdx
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SOURCE_FRAGMENT_IDX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSourceFragmentIdx() {
    return sourceFragmentIdx;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE_FRAGMENT_IDX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceFragmentIdx(Integer sourceFragmentIdx) {
    this.sourceFragmentIdx = sourceFragmentIdx;
  }

  public LossEdge targetFragmentIdx(Integer targetFragmentIdx) {
    
    this.targetFragmentIdx = targetFragmentIdx;
    return this;
  }

   /**
   * Get targetFragmentIdx
   * @return targetFragmentIdx
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TARGET_FRAGMENT_IDX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTargetFragmentIdx() {
    return targetFragmentIdx;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_FRAGMENT_IDX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTargetFragmentIdx(Integer targetFragmentIdx) {
    this.targetFragmentIdx = targetFragmentIdx;
  }

  public LossEdge molecularFormula(String molecularFormula) {
    
    this.molecularFormula = molecularFormula;
    return this;
  }

   /**
   * Get molecularFormula
   * @return molecularFormula
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MOLECULAR_FORMULA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMolecularFormula() {
    return molecularFormula;
  }


  @JsonProperty(JSON_PROPERTY_MOLECULAR_FORMULA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMolecularFormula(String molecularFormula) {
    this.molecularFormula = molecularFormula;
  }

  public LossEdge score(Double score) {
    
    this.score = score;
    return this;
  }

   /**
   * Get score
   * @return score
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getScore() {
    return score;
  }


  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScore(Double score) {
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LossEdge lossEdge = (LossEdge) o;
    return Objects.equals(this.sourceFragmentIdx, lossEdge.sourceFragmentIdx) &&
        Objects.equals(this.targetFragmentIdx, lossEdge.targetFragmentIdx) &&
        Objects.equals(this.molecularFormula, lossEdge.molecularFormula) &&
        Objects.equals(this.score, lossEdge.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceFragmentIdx, targetFragmentIdx, molecularFormula, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LossEdge {\n");
    sb.append("    sourceFragmentIdx: ").append(toIndentedString(sourceFragmentIdx)).append("\n");
    sb.append("    targetFragmentIdx: ").append(toIndentedString(targetFragmentIdx)).append("\n");
    sb.append("    molecularFormula: ").append(toIndentedString(molecularFormula)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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


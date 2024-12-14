/*
 * SIRIUS Nightsky API
 * REST API that provides the full functionality of SIRIUS and its web services as background service. It is intended as entry-point for scripting languages and software integration SDKs.This API is exposed by SIRIUS 6
 *
 * The version of the OpenAPI document: 2.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
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
 * CompoundFoldChange
 */
@JsonPropertyOrder({
  CompoundFoldChange.JSON_PROPERTY_LEFT_GROUP,
  CompoundFoldChange.JSON_PROPERTY_RIGHT_GROUP,
  CompoundFoldChange.JSON_PROPERTY_AGGREGATION,
  CompoundFoldChange.JSON_PROPERTY_QUANTIFICATION,
  CompoundFoldChange.JSON_PROPERTY_FOLD_CHANGE,
  CompoundFoldChange.JSON_PROPERTY_COMPOUND_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class CompoundFoldChange {
  public static final String JSON_PROPERTY_LEFT_GROUP = "leftGroup";
  private String leftGroup;

  public static final String JSON_PROPERTY_RIGHT_GROUP = "rightGroup";
  private String rightGroup;

  /**
   * Gets or Sets aggregation
   */
  public enum AggregationEnum {
    AVG("AVG"),
    
    MIN("MIN"),
    
    MAX("MAX");

    private String value;

    AggregationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AggregationEnum fromValue(String value) {
      for (AggregationEnum b : AggregationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_AGGREGATION = "aggregation";
  private AggregationEnum aggregation;

  /**
   * Gets or Sets quantification
   */
  public enum QuantificationEnum {
    APEX_INTENSITY("APEX_INTENSITY"),
    
    AREA_UNDER_CURVE("AREA_UNDER_CURVE");

    private String value;

    QuantificationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static QuantificationEnum fromValue(String value) {
      for (QuantificationEnum b : QuantificationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_QUANTIFICATION = "quantification";
  private QuantificationEnum quantification;

  public static final String JSON_PROPERTY_FOLD_CHANGE = "foldChange";
  private Double foldChange;

  public static final String JSON_PROPERTY_COMPOUND_ID = "compoundId";
  private String compoundId;

  public CompoundFoldChange() {
  }

  public CompoundFoldChange leftGroup(String leftGroup) {
    
    this.leftGroup = leftGroup;
    return this;
  }

   /**
   * Get leftGroup
   * @return leftGroup
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LEFT_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLeftGroup() {
    return leftGroup;
  }


  @JsonProperty(JSON_PROPERTY_LEFT_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLeftGroup(String leftGroup) {
    this.leftGroup = leftGroup;
  }

  public CompoundFoldChange rightGroup(String rightGroup) {
    
    this.rightGroup = rightGroup;
    return this;
  }

   /**
   * Get rightGroup
   * @return rightGroup
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RIGHT_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRightGroup() {
    return rightGroup;
  }


  @JsonProperty(JSON_PROPERTY_RIGHT_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRightGroup(String rightGroup) {
    this.rightGroup = rightGroup;
  }

  public CompoundFoldChange aggregation(AggregationEnum aggregation) {
    
    this.aggregation = aggregation;
    return this;
  }

   /**
   * Get aggregation
   * @return aggregation
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AGGREGATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AggregationEnum getAggregation() {
    return aggregation;
  }


  @JsonProperty(JSON_PROPERTY_AGGREGATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAggregation(AggregationEnum aggregation) {
    this.aggregation = aggregation;
  }

  public CompoundFoldChange quantification(QuantificationEnum quantification) {
    
    this.quantification = quantification;
    return this;
  }

   /**
   * Get quantification
   * @return quantification
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_QUANTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public QuantificationEnum getQuantification() {
    return quantification;
  }


  @JsonProperty(JSON_PROPERTY_QUANTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuantification(QuantificationEnum quantification) {
    this.quantification = quantification;
  }

  public CompoundFoldChange foldChange(Double foldChange) {
    
    this.foldChange = foldChange;
    return this;
  }

   /**
   * Get foldChange
   * @return foldChange
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FOLD_CHANGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getFoldChange() {
    return foldChange;
  }


  @JsonProperty(JSON_PROPERTY_FOLD_CHANGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFoldChange(Double foldChange) {
    this.foldChange = foldChange;
  }

  public CompoundFoldChange compoundId(String compoundId) {
    
    this.compoundId = compoundId;
    return this;
  }

   /**
   * Get compoundId
   * @return compoundId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMPOUND_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCompoundId() {
    return compoundId;
  }


  @JsonProperty(JSON_PROPERTY_COMPOUND_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompoundId(String compoundId) {
    this.compoundId = compoundId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompoundFoldChange compoundFoldChange = (CompoundFoldChange) o;
    return Objects.equals(this.leftGroup, compoundFoldChange.leftGroup) &&
        Objects.equals(this.rightGroup, compoundFoldChange.rightGroup) &&
        Objects.equals(this.aggregation, compoundFoldChange.aggregation) &&
        Objects.equals(this.quantification, compoundFoldChange.quantification) &&
        Objects.equals(this.foldChange, compoundFoldChange.foldChange) &&
        Objects.equals(this.compoundId, compoundFoldChange.compoundId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftGroup, rightGroup, aggregation, quantification, foldChange, compoundId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompoundFoldChange {\n");
    sb.append("    leftGroup: ").append(toIndentedString(leftGroup)).append("\n");
    sb.append("    rightGroup: ").append(toIndentedString(rightGroup)).append("\n");
    sb.append("    aggregation: ").append(toIndentedString(aggregation)).append("\n");
    sb.append("    quantification: ").append(toIndentedString(quantification)).append("\n");
    sb.append("    foldChange: ").append(toIndentedString(foldChange)).append("\n");
    sb.append("    compoundId: ").append(toIndentedString(compoundId)).append("\n");
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


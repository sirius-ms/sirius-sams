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


package de.unijena.bioinf.ms.nightsky.sdk.model;

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
 * DoubleTagFilter
 */
@JsonPropertyOrder({
  DoubleTagFilter.JSON_PROPERTY_EQUALS,
  DoubleTagFilter.JSON_PROPERTY_LESS_THAN,
  DoubleTagFilter.JSON_PROPERTY_LESS_THAN_EQUALS,
  DoubleTagFilter.JSON_PROPERTY_GREATER_THAN,
  DoubleTagFilter.JSON_PROPERTY_GREATER_THAN_EQUALS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class DoubleTagFilter {
  public static final String JSON_PROPERTY_EQUALS = "equals";
  private Double equals;

  public static final String JSON_PROPERTY_LESS_THAN = "lessThan";
  private Double lessThan;

  public static final String JSON_PROPERTY_LESS_THAN_EQUALS = "lessThanEquals";
  private Double lessThanEquals;

  public static final String JSON_PROPERTY_GREATER_THAN = "greaterThan";
  private Double greaterThan;

  public static final String JSON_PROPERTY_GREATER_THAN_EQUALS = "greaterThanEquals";
  private Double greaterThanEquals;

  public DoubleTagFilter() {
  }

  public DoubleTagFilter equals(Double equals) {
    
    this.equals = equals;
    return this;
  }

   /**
   * Get equals
   * @return equals
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getEquals() {
    return equals;
  }


  @JsonProperty(JSON_PROPERTY_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEquals(Double equals) {
    this.equals = equals;
  }

  public DoubleTagFilter lessThan(Double lessThan) {
    
    this.lessThan = lessThan;
    return this;
  }

   /**
   * Get lessThan
   * @return lessThan
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LESS_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLessThan() {
    return lessThan;
  }


  @JsonProperty(JSON_PROPERTY_LESS_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLessThan(Double lessThan) {
    this.lessThan = lessThan;
  }

  public DoubleTagFilter lessThanEquals(Double lessThanEquals) {
    
    this.lessThanEquals = lessThanEquals;
    return this;
  }

   /**
   * Get lessThanEquals
   * @return lessThanEquals
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LESS_THAN_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLessThanEquals() {
    return lessThanEquals;
  }


  @JsonProperty(JSON_PROPERTY_LESS_THAN_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLessThanEquals(Double lessThanEquals) {
    this.lessThanEquals = lessThanEquals;
  }

  public DoubleTagFilter greaterThan(Double greaterThan) {
    
    this.greaterThan = greaterThan;
    return this;
  }

   /**
   * Get greaterThan
   * @return greaterThan
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GREATER_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getGreaterThan() {
    return greaterThan;
  }


  @JsonProperty(JSON_PROPERTY_GREATER_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGreaterThan(Double greaterThan) {
    this.greaterThan = greaterThan;
  }

  public DoubleTagFilter greaterThanEquals(Double greaterThanEquals) {
    
    this.greaterThanEquals = greaterThanEquals;
    return this;
  }

   /**
   * Get greaterThanEquals
   * @return greaterThanEquals
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GREATER_THAN_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getGreaterThanEquals() {
    return greaterThanEquals;
  }


  @JsonProperty(JSON_PROPERTY_GREATER_THAN_EQUALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGreaterThanEquals(Double greaterThanEquals) {
    this.greaterThanEquals = greaterThanEquals;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoubleTagFilter doubleTagFilter = (DoubleTagFilter) o;
    return Objects.equals(this.equals, doubleTagFilter.equals) &&
        Objects.equals(this.lessThan, doubleTagFilter.lessThan) &&
        Objects.equals(this.lessThanEquals, doubleTagFilter.lessThanEquals) &&
        Objects.equals(this.greaterThan, doubleTagFilter.greaterThan) &&
        Objects.equals(this.greaterThanEquals, doubleTagFilter.greaterThanEquals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equals, lessThan, lessThanEquals, greaterThan, greaterThanEquals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoubleTagFilter {\n");
    sb.append("    equals: ").append(toIndentedString(equals)).append("\n");
    sb.append("    lessThan: ").append(toIndentedString(lessThan)).append("\n");
    sb.append("    lessThanEquals: ").append(toIndentedString(lessThanEquals)).append("\n");
    sb.append("    greaterThan: ").append(toIndentedString(greaterThan)).append("\n");
    sb.append("    greaterThanEquals: ").append(toIndentedString(greaterThanEquals)).append("\n");
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


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
 * 
 */
@JsonPropertyOrder({
  PeakAnnotation.JSON_PROPERTY_MOLECULAR_FORMULA,
  PeakAnnotation.JSON_PROPERTY_EXACT_MASS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PeakAnnotation {
  public static final String JSON_PROPERTY_MOLECULAR_FORMULA = "molecularFormula";
  private String molecularFormula;

  public static final String JSON_PROPERTY_EXACT_MASS = "exactMass";
  private Double exactMass;

  public PeakAnnotation() {
  }

  public PeakAnnotation molecularFormula(String molecularFormula) {
    
    this.molecularFormula = molecularFormula;
    return this;
  }

   /**
   * Get molecularFormula
   * @return molecularFormula
  **/
  @javax.annotation.Nullable
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


  public PeakAnnotation exactMass(Double exactMass) {
    
    this.exactMass = exactMass;
    return this;
  }

   /**
   * Get exactMass
   * @return exactMass
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXACT_MASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getExactMass() {
    return exactMass;
  }


  @JsonProperty(JSON_PROPERTY_EXACT_MASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExactMass(Double exactMass) {
    this.exactMass = exactMass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeakAnnotation peakAnnotation = (PeakAnnotation) o;
    return Objects.equals(this.molecularFormula, peakAnnotation.molecularFormula) &&
        Objects.equals(this.exactMass, peakAnnotation.exactMass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(molecularFormula, exactMass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeakAnnotation {\n");
    sb.append("    molecularFormula: ").append(toIndentedString(molecularFormula)).append("\n");
    sb.append("    exactMass: ").append(toIndentedString(exactMass)).append("\n");
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


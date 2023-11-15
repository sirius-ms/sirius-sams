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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * 
 */
@JsonPropertyOrder({
  Timeout.JSON_PROPERTY_NUMBER_OF_SECONDS_PER_DECOMPOSITION,
  Timeout.JSON_PROPERTY_NUMBER_OF_SECONDS_PER_INSTANCE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Timeout {
  public static final String JSON_PROPERTY_NUMBER_OF_SECONDS_PER_DECOMPOSITION = "numberOfSecondsPerDecomposition";
  private Integer numberOfSecondsPerDecomposition;

  public static final String JSON_PROPERTY_NUMBER_OF_SECONDS_PER_INSTANCE = "numberOfSecondsPerInstance";
  private Integer numberOfSecondsPerInstance;

  public Timeout() { 
  }

  public Timeout numberOfSecondsPerDecomposition(Integer numberOfSecondsPerDecomposition) {
    this.numberOfSecondsPerDecomposition = numberOfSecondsPerDecomposition;
    return this;
  }

   /**
   * Get numberOfSecondsPerDecomposition
   * @return numberOfSecondsPerDecomposition
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NUMBER_OF_SECONDS_PER_DECOMPOSITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNumberOfSecondsPerDecomposition() {
    return numberOfSecondsPerDecomposition;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER_OF_SECONDS_PER_DECOMPOSITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberOfSecondsPerDecomposition(Integer numberOfSecondsPerDecomposition) {
    this.numberOfSecondsPerDecomposition = numberOfSecondsPerDecomposition;
  }


  public Timeout numberOfSecondsPerInstance(Integer numberOfSecondsPerInstance) {
    this.numberOfSecondsPerInstance = numberOfSecondsPerInstance;
    return this;
  }

   /**
   * Get numberOfSecondsPerInstance
   * @return numberOfSecondsPerInstance
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NUMBER_OF_SECONDS_PER_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNumberOfSecondsPerInstance() {
    return numberOfSecondsPerInstance;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER_OF_SECONDS_PER_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberOfSecondsPerInstance(Integer numberOfSecondsPerInstance) {
    this.numberOfSecondsPerInstance = numberOfSecondsPerInstance;
  }


  /**
   * Return true if this Timeout object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Timeout timeout = (Timeout) o;
    return Objects.equals(this.numberOfSecondsPerDecomposition, timeout.numberOfSecondsPerDecomposition) &&
        Objects.equals(this.numberOfSecondsPerInstance, timeout.numberOfSecondsPerInstance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfSecondsPerDecomposition, numberOfSecondsPerInstance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Timeout {\n");
    sb.append("    numberOfSecondsPerDecomposition: ").append(toIndentedString(numberOfSecondsPerDecomposition)).append("\n");
    sb.append("    numberOfSecondsPerInstance: ").append(toIndentedString(numberOfSecondsPerInstance)).append("\n");
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

    // add `numberOfSecondsPerDecomposition` to the URL query string
    if (getNumberOfSecondsPerDecomposition() != null) {
      joiner.add(String.format("%snumberOfSecondsPerDecomposition%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumberOfSecondsPerDecomposition()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `numberOfSecondsPerInstance` to the URL query string
    if (getNumberOfSecondsPerInstance() != null) {
      joiner.add(String.format("%snumberOfSecondsPerInstance%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumberOfSecondsPerInstance()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}


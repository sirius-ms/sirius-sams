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
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * 
 */
@JsonPropertyOrder({
  FragmentNode.JSON_PROPERTY_ID,
  FragmentNode.JSON_PROPERTY_MOLECULAR_FORMULA,
  FragmentNode.JSON_PROPERTY_ION_TYPE,
  FragmentNode.JSON_PROPERTY_MASS_DEVIATION_DA,
  FragmentNode.JSON_PROPERTY_MASS_DEVIATION_PPM,
  FragmentNode.JSON_PROPERTY_SCORE,
  FragmentNode.JSON_PROPERTY_INTENSITY,
  FragmentNode.JSON_PROPERTY_MZ
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FragmentNode {
  public static final String JSON_PROPERTY_ID = "id";
  private Integer id;

  public static final String JSON_PROPERTY_MOLECULAR_FORMULA = "molecularFormula";
  private JsonNullable<String> molecularFormula = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ION_TYPE = "ionType";
  private JsonNullable<String> ionType = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_MASS_DEVIATION_DA = "massDeviationDa";
  private JsonNullable<Double> massDeviationDa = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_MASS_DEVIATION_PPM = "massDeviationPpm";
  private JsonNullable<Double> massDeviationPpm = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_SCORE = "score";
  private JsonNullable<Double> score = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_INTENSITY = "intensity";
  private JsonNullable<Double> intensity = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_MZ = "mz";
  private JsonNullable<Double> mz = JsonNullable.<Double>undefined();

  public FragmentNode() { 
  }

  public FragmentNode id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(Integer id) {
    this.id = id;
  }


  public FragmentNode molecularFormula(String molecularFormula) {
    this.molecularFormula = JsonNullable.<String>of(molecularFormula);
    return this;
  }

   /**
   * Get molecularFormula
   * @return molecularFormula
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getMolecularFormula() {
        return molecularFormula.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOLECULAR_FORMULA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getMolecularFormula_JsonNullable() {
    return molecularFormula;
  }
  
  @JsonProperty(JSON_PROPERTY_MOLECULAR_FORMULA)
  public void setMolecularFormula_JsonNullable(JsonNullable<String> molecularFormula) {
    this.molecularFormula = molecularFormula;
  }

  public void setMolecularFormula(String molecularFormula) {
    this.molecularFormula = JsonNullable.<String>of(molecularFormula);
  }


  public FragmentNode ionType(String ionType) {
    this.ionType = JsonNullable.<String>of(ionType);
    return this;
  }

   /**
   * Get ionType
   * @return ionType
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getIonType() {
        return ionType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getIonType_JsonNullable() {
    return ionType;
  }
  
  @JsonProperty(JSON_PROPERTY_ION_TYPE)
  public void setIonType_JsonNullable(JsonNullable<String> ionType) {
    this.ionType = ionType;
  }

  public void setIonType(String ionType) {
    this.ionType = JsonNullable.<String>of(ionType);
  }


  public FragmentNode massDeviationDa(Double massDeviationDa) {
    this.massDeviationDa = JsonNullable.<Double>of(massDeviationDa);
    return this;
  }

   /**
   * Get massDeviationDa
   * @return massDeviationDa
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Double getMassDeviationDa() {
        return massDeviationDa.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MASS_DEVIATION_DA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getMassDeviationDa_JsonNullable() {
    return massDeviationDa;
  }
  
  @JsonProperty(JSON_PROPERTY_MASS_DEVIATION_DA)
  public void setMassDeviationDa_JsonNullable(JsonNullable<Double> massDeviationDa) {
    this.massDeviationDa = massDeviationDa;
  }

  public void setMassDeviationDa(Double massDeviationDa) {
    this.massDeviationDa = JsonNullable.<Double>of(massDeviationDa);
  }


  public FragmentNode massDeviationPpm(Double massDeviationPpm) {
    this.massDeviationPpm = JsonNullable.<Double>of(massDeviationPpm);
    return this;
  }

   /**
   * Get massDeviationPpm
   * @return massDeviationPpm
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Double getMassDeviationPpm() {
        return massDeviationPpm.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MASS_DEVIATION_PPM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getMassDeviationPpm_JsonNullable() {
    return massDeviationPpm;
  }
  
  @JsonProperty(JSON_PROPERTY_MASS_DEVIATION_PPM)
  public void setMassDeviationPpm_JsonNullable(JsonNullable<Double> massDeviationPpm) {
    this.massDeviationPpm = massDeviationPpm;
  }

  public void setMassDeviationPpm(Double massDeviationPpm) {
    this.massDeviationPpm = JsonNullable.<Double>of(massDeviationPpm);
  }


  public FragmentNode score(Double score) {
    this.score = JsonNullable.<Double>of(score);
    return this;
  }

   /**
   * Get score
   * @return score
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Double getScore() {
        return score.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getScore_JsonNullable() {
    return score;
  }
  
  @JsonProperty(JSON_PROPERTY_SCORE)
  public void setScore_JsonNullable(JsonNullable<Double> score) {
    this.score = score;
  }

  public void setScore(Double score) {
    this.score = JsonNullable.<Double>of(score);
  }


  public FragmentNode intensity(Double intensity) {
    this.intensity = JsonNullable.<Double>of(intensity);
    return this;
  }

   /**
   * Get intensity
   * @return intensity
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Double getIntensity() {
        return intensity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTENSITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getIntensity_JsonNullable() {
    return intensity;
  }
  
  @JsonProperty(JSON_PROPERTY_INTENSITY)
  public void setIntensity_JsonNullable(JsonNullable<Double> intensity) {
    this.intensity = intensity;
  }

  public void setIntensity(Double intensity) {
    this.intensity = JsonNullable.<Double>of(intensity);
  }


  public FragmentNode mz(Double mz) {
    this.mz = JsonNullable.<Double>of(mz);
    return this;
  }

   /**
   * Get mz
   * @return mz
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Double getMz() {
        return mz.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MZ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getMz_JsonNullable() {
    return mz;
  }
  
  @JsonProperty(JSON_PROPERTY_MZ)
  public void setMz_JsonNullable(JsonNullable<Double> mz) {
    this.mz = mz;
  }

  public void setMz(Double mz) {
    this.mz = JsonNullable.<Double>of(mz);
  }


  /**
   * Return true if this FragmentNode object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FragmentNode fragmentNode = (FragmentNode) o;
    return Objects.equals(this.id, fragmentNode.id) &&
        equalsNullable(this.molecularFormula, fragmentNode.molecularFormula) &&
        equalsNullable(this.ionType, fragmentNode.ionType) &&
        equalsNullable(this.massDeviationDa, fragmentNode.massDeviationDa) &&
        equalsNullable(this.massDeviationPpm, fragmentNode.massDeviationPpm) &&
        equalsNullable(this.score, fragmentNode.score) &&
        equalsNullable(this.intensity, fragmentNode.intensity) &&
        equalsNullable(this.mz, fragmentNode.mz);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hashCodeNullable(molecularFormula), hashCodeNullable(ionType), hashCodeNullable(massDeviationDa), hashCodeNullable(massDeviationPpm), hashCodeNullable(score), hashCodeNullable(intensity), hashCodeNullable(mz));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FragmentNode {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    molecularFormula: ").append(toIndentedString(molecularFormula)).append("\n");
    sb.append("    ionType: ").append(toIndentedString(ionType)).append("\n");
    sb.append("    massDeviationDa: ").append(toIndentedString(massDeviationDa)).append("\n");
    sb.append("    massDeviationPpm: ").append(toIndentedString(massDeviationPpm)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    intensity: ").append(toIndentedString(intensity)).append("\n");
    sb.append("    mz: ").append(toIndentedString(mz)).append("\n");
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

    // add `molecularFormula` to the URL query string
    if (getMolecularFormula() != null) {
      joiner.add(String.format("%smolecularFormula%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMolecularFormula()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `ionType` to the URL query string
    if (getIonType() != null) {
      joiner.add(String.format("%sionType%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIonType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `massDeviationDa` to the URL query string
    if (getMassDeviationDa() != null) {
      joiner.add(String.format("%smassDeviationDa%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMassDeviationDa()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `massDeviationPpm` to the URL query string
    if (getMassDeviationPpm() != null) {
      joiner.add(String.format("%smassDeviationPpm%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMassDeviationPpm()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `score` to the URL query string
    if (getScore() != null) {
      joiner.add(String.format("%sscore%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getScore()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `intensity` to the URL query string
    if (getIntensity() != null) {
      joiner.add(String.format("%sintensity%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIntensity()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `mz` to the URL query string
    if (getMz() != null) {
      joiner.add(String.format("%smz%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMz()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}


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
import de.unijena.bioinf.ms.nightsky.sdk.model.GuiResultTab;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Parameters to \&quot;remote control\&quot; the SIRIUS GUI.
 */
@JsonPropertyOrder({
  GuiParameters.JSON_PROPERTY_SELECTED_TAB,
  GuiParameters.JSON_PROPERTY_CID,
  GuiParameters.JSON_PROPERTY_FID,
  GuiParameters.JSON_PROPERTY_STRUCTURE_CANDIDATE_IN_CH_I_KEY,
  GuiParameters.JSON_PROPERTY_BRING_TO_FRONT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-11T15:12:24.554845061+01:00[Europe/Berlin]")
public class GuiParameters {
  public static final String JSON_PROPERTY_SELECTED_TAB = "selectedTab";
  private JsonNullable<GuiResultTab> selectedTab = JsonNullable.<GuiResultTab>undefined();

  public static final String JSON_PROPERTY_CID = "cid";
  private JsonNullable<String> cid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_FID = "fid";
  private JsonNullable<String> fid = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_STRUCTURE_CANDIDATE_IN_CH_I_KEY = "structureCandidateInChIKey";
  private JsonNullable<String> structureCandidateInChIKey = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_BRING_TO_FRONT = "bringToFront";
  private JsonNullable<Boolean> bringToFront = JsonNullable.<Boolean>undefined();

  public GuiParameters() { 
  }

  public GuiParameters selectedTab(GuiResultTab selectedTab) {
    this.selectedTab = JsonNullable.<GuiResultTab>of(selectedTab);
    return this;
  }

   /**
   * Get selectedTab
   * @return selectedTab
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public GuiResultTab getSelectedTab() {
        return selectedTab.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SELECTED_TAB)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<GuiResultTab> getSelectedTab_JsonNullable() {
    return selectedTab;
  }
  
  @JsonProperty(JSON_PROPERTY_SELECTED_TAB)
  public void setSelectedTab_JsonNullable(JsonNullable<GuiResultTab> selectedTab) {
    this.selectedTab = selectedTab;
  }

  public void setSelectedTab(GuiResultTab selectedTab) {
    this.selectedTab = JsonNullable.<GuiResultTab>of(selectedTab);
  }


  public GuiParameters cid(String cid) {
    this.cid = JsonNullable.<String>of(cid);
    return this;
  }

   /**
   * ID of Selected compound.
   * @return cid
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getCid() {
        return cid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCid_JsonNullable() {
    return cid;
  }
  
  @JsonProperty(JSON_PROPERTY_CID)
  public void setCid_JsonNullable(JsonNullable<String> cid) {
    this.cid = cid;
  }

  public void setCid(String cid) {
    this.cid = JsonNullable.<String>of(cid);
  }


  public GuiParameters fid(String fid) {
    this.fid = JsonNullable.<String>of(fid);
    return this;
  }

   /**
   * ID of Selected Formula candidate of the selected compound.
   * @return fid
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getFid() {
        return fid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getFid_JsonNullable() {
    return fid;
  }
  
  @JsonProperty(JSON_PROPERTY_FID)
  public void setFid_JsonNullable(JsonNullable<String> fid) {
    this.fid = fid;
  }

  public void setFid(String fid) {
    this.fid = JsonNullable.<String>of(fid);
  }


  public GuiParameters structureCandidateInChIKey(String structureCandidateInChIKey) {
    this.structureCandidateInChIKey = JsonNullable.<String>of(structureCandidateInChIKey);
    return this;
  }

   /**
   * InChIKey of selected structure candidate of selected formula candidate.
   * @return structureCandidateInChIKey
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getStructureCandidateInChIKey() {
        return structureCandidateInChIKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRUCTURE_CANDIDATE_IN_CH_I_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getStructureCandidateInChIKey_JsonNullable() {
    return structureCandidateInChIKey;
  }
  
  @JsonProperty(JSON_PROPERTY_STRUCTURE_CANDIDATE_IN_CH_I_KEY)
  public void setStructureCandidateInChIKey_JsonNullable(JsonNullable<String> structureCandidateInChIKey) {
    this.structureCandidateInChIKey = structureCandidateInChIKey;
  }

  public void setStructureCandidateInChIKey(String structureCandidateInChIKey) {
    this.structureCandidateInChIKey = JsonNullable.<String>of(structureCandidateInChIKey);
  }


  public GuiParameters bringToFront(Boolean bringToFront) {
    this.bringToFront = JsonNullable.<Boolean>of(bringToFront);
    return this;
  }

   /**
   * If true bring SIRIUS GUI window to foreground.
   * @return bringToFront
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Boolean getBringToFront() {
        return bringToFront.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BRING_TO_FRONT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Boolean> getBringToFront_JsonNullable() {
    return bringToFront;
  }
  
  @JsonProperty(JSON_PROPERTY_BRING_TO_FRONT)
  public void setBringToFront_JsonNullable(JsonNullable<Boolean> bringToFront) {
    this.bringToFront = bringToFront;
  }

  public void setBringToFront(Boolean bringToFront) {
    this.bringToFront = JsonNullable.<Boolean>of(bringToFront);
  }


  /**
   * Return true if this GuiParameters object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GuiParameters guiParameters = (GuiParameters) o;
    return equalsNullable(this.selectedTab, guiParameters.selectedTab) &&
        equalsNullable(this.cid, guiParameters.cid) &&
        equalsNullable(this.fid, guiParameters.fid) &&
        equalsNullable(this.structureCandidateInChIKey, guiParameters.structureCandidateInChIKey) &&
        equalsNullable(this.bringToFront, guiParameters.bringToFront);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(selectedTab), hashCodeNullable(cid), hashCodeNullable(fid), hashCodeNullable(structureCandidateInChIKey), hashCodeNullable(bringToFront));
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
    sb.append("class GuiParameters {\n");
    sb.append("    selectedTab: ").append(toIndentedString(selectedTab)).append("\n");
    sb.append("    cid: ").append(toIndentedString(cid)).append("\n");
    sb.append("    fid: ").append(toIndentedString(fid)).append("\n");
    sb.append("    structureCandidateInChIKey: ").append(toIndentedString(structureCandidateInChIKey)).append("\n");
    sb.append("    bringToFront: ").append(toIndentedString(bringToFront)).append("\n");
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

    // add `selectedTab` to the URL query string
    if (getSelectedTab() != null) {
      joiner.add(String.format("%sselectedTab%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSelectedTab()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `cid` to the URL query string
    if (getCid() != null) {
      joiner.add(String.format("%scid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCid()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `fid` to the URL query string
    if (getFid() != null) {
      joiner.add(String.format("%sfid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFid()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `structureCandidateInChIKey` to the URL query string
    if (getStructureCandidateInChIKey() != null) {
      joiner.add(String.format("%sstructureCandidateInChIKey%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStructureCandidateInChIKey()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `bringToFront` to the URL query string
    if (getBringToFront() != null) {
      joiner.add(String.format("%sbringToFront%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getBringToFront()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}


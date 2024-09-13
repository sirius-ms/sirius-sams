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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.unijena.bioinf.ms.nightsky.sdk.model.BasicSpectrum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Represents an (aligned) feature to be imported into a SIRIUS project.  At least one of the Mass Spec data sources (e.g. mergedMs1, ms1Spectra, ms2Spectra) needs to be given.  Otherwise, the import will fail.
 */
@JsonPropertyOrder({
  FeatureImport.JSON_PROPERTY_NAME,
  FeatureImport.JSON_PROPERTY_EXTERNAL_FEATURE_ID,
  FeatureImport.JSON_PROPERTY_ION_MASS,
  FeatureImport.JSON_PROPERTY_CHARGE,
  FeatureImport.JSON_PROPERTY_DETECTED_ADDUCTS,
  FeatureImport.JSON_PROPERTY_RT_START_SECONDS,
  FeatureImport.JSON_PROPERTY_RT_END_SECONDS,
  FeatureImport.JSON_PROPERTY_RT_APEX_SECONDS,
  FeatureImport.JSON_PROPERTY_MERGED_MS1,
  FeatureImport.JSON_PROPERTY_MS1_SPECTRA,
  FeatureImport.JSON_PROPERTY_MS2_SPECTRA
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class FeatureImport {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_EXTERNAL_FEATURE_ID = "externalFeatureId";
  private String externalFeatureId;

  public static final String JSON_PROPERTY_ION_MASS = "ionMass";
  private Double ionMass;

  public static final String JSON_PROPERTY_CHARGE = "charge";
  private Integer charge;

  public static final String JSON_PROPERTY_DETECTED_ADDUCTS = "detectedAdducts";
  private Set<String> detectedAdducts;

  public static final String JSON_PROPERTY_RT_START_SECONDS = "rtStartSeconds";
  private Double rtStartSeconds;

  public static final String JSON_PROPERTY_RT_END_SECONDS = "rtEndSeconds";
  private Double rtEndSeconds;

  public static final String JSON_PROPERTY_RT_APEX_SECONDS = "rtApexSeconds";
  private Double rtApexSeconds;

  public static final String JSON_PROPERTY_MERGED_MS1 = "mergedMs1";
  private BasicSpectrum mergedMs1;

  public static final String JSON_PROPERTY_MS1_SPECTRA = "ms1Spectra";
  private List<BasicSpectrum> ms1Spectra;

  public static final String JSON_PROPERTY_MS2_SPECTRA = "ms2Spectra";
  private List<BasicSpectrum> ms2Spectra;

  public FeatureImport() {
  }

  public FeatureImport name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  public FeatureImport externalFeatureId(String externalFeatureId) {
    
    this.externalFeatureId = externalFeatureId;
    return this;
  }

   /**
   * Externally provided FeatureId (by some preprocessing tool). This FeatureId is NOT used by SIRIUS but is stored to ease mapping information back to the source.
   * @return externalFeatureId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTERNAL_FEATURE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExternalFeatureId() {
    return externalFeatureId;
  }


  @JsonProperty(JSON_PROPERTY_EXTERNAL_FEATURE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalFeatureId(String externalFeatureId) {
    this.externalFeatureId = externalFeatureId;
  }

  public FeatureImport ionMass(Double ionMass) {
    
    this.ionMass = ionMass;
    return this;
  }

   /**
   * Get ionMass
   * @return ionMass
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ION_MASS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getIonMass() {
    return ionMass;
  }


  @JsonProperty(JSON_PROPERTY_ION_MASS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIonMass(Double ionMass) {
    this.ionMass = ionMass;
  }

  public FeatureImport charge(Integer charge) {
    
    this.charge = charge;
    return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CHARGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCharge() {
    return charge;
  }


  @JsonProperty(JSON_PROPERTY_CHARGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCharge(Integer charge) {
    this.charge = charge;
  }

  public FeatureImport detectedAdducts(Set<String> detectedAdducts) {
    
    this.detectedAdducts = detectedAdducts;
    return this;
  }

  public FeatureImport addDetectedAdductsItem(String detectedAdductsItem) {
    if (this.detectedAdducts == null) {
      this.detectedAdducts = new LinkedHashSet<>();
    }
    this.detectedAdducts.add(detectedAdductsItem);
    return this;
  }

   /**
   * Detected adducts of this feature. Can be NULL or empty if no adducts are known.
   * @return detectedAdducts
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DETECTED_ADDUCTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<String> getDetectedAdducts() {
    return detectedAdducts;
  }


  @JsonDeserialize(as = LinkedHashSet.class)
  @JsonProperty(JSON_PROPERTY_DETECTED_ADDUCTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetectedAdducts(Set<String> detectedAdducts) {
    this.detectedAdducts = detectedAdducts;
  }

  public FeatureImport rtStartSeconds(Double rtStartSeconds) {
    
    this.rtStartSeconds = rtStartSeconds;
    return this;
  }

   /**
   * Get rtStartSeconds
   * @return rtStartSeconds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RT_START_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getRtStartSeconds() {
    return rtStartSeconds;
  }


  @JsonProperty(JSON_PROPERTY_RT_START_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRtStartSeconds(Double rtStartSeconds) {
    this.rtStartSeconds = rtStartSeconds;
  }

  public FeatureImport rtEndSeconds(Double rtEndSeconds) {
    
    this.rtEndSeconds = rtEndSeconds;
    return this;
  }

   /**
   * Get rtEndSeconds
   * @return rtEndSeconds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RT_END_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getRtEndSeconds() {
    return rtEndSeconds;
  }


  @JsonProperty(JSON_PROPERTY_RT_END_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRtEndSeconds(Double rtEndSeconds) {
    this.rtEndSeconds = rtEndSeconds;
  }

  public FeatureImport rtApexSeconds(Double rtApexSeconds) {
    
    this.rtApexSeconds = rtApexSeconds;
    return this;
  }

   /**
   * Get rtApexSeconds
   * @return rtApexSeconds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RT_APEX_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getRtApexSeconds() {
    return rtApexSeconds;
  }


  @JsonProperty(JSON_PROPERTY_RT_APEX_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRtApexSeconds(Double rtApexSeconds) {
    this.rtApexSeconds = rtApexSeconds;
  }

  public FeatureImport mergedMs1(BasicSpectrum mergedMs1) {
    
    this.mergedMs1 = mergedMs1;
    return this;
  }

   /**
   * Get mergedMs1
   * @return mergedMs1
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MERGED_MS1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BasicSpectrum getMergedMs1() {
    return mergedMs1;
  }


  @JsonProperty(JSON_PROPERTY_MERGED_MS1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMergedMs1(BasicSpectrum mergedMs1) {
    this.mergedMs1 = mergedMs1;
  }

  public FeatureImport ms1Spectra(List<BasicSpectrum> ms1Spectra) {
    
    this.ms1Spectra = ms1Spectra;
    return this;
  }

  public FeatureImport addMs1SpectraItem(BasicSpectrum ms1SpectraItem) {
    if (this.ms1Spectra == null) {
      this.ms1Spectra = new ArrayList<>();
    }
    this.ms1Spectra.add(ms1SpectraItem);
    return this;
  }

   /**
   * List of MS1Spectra belonging to this feature. These spectra will be merged an only a representative  mergedMs1 spectrum will be stored in SIRIUS. At least one of these spectra should contain the  isotope pattern of the precursor ion.  Note: Will be ignored if &#39;mergedMs1&#39; is given.
   * @return ms1Spectra
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MS1_SPECTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<BasicSpectrum> getMs1Spectra() {
    return ms1Spectra;
  }


  @JsonProperty(JSON_PROPERTY_MS1_SPECTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMs1Spectra(List<BasicSpectrum> ms1Spectra) {
    this.ms1Spectra = ms1Spectra;
  }

  public FeatureImport ms2Spectra(List<BasicSpectrum> ms2Spectra) {
    
    this.ms2Spectra = ms2Spectra;
    return this;
  }

  public FeatureImport addMs2SpectraItem(BasicSpectrum ms2SpectraItem) {
    if (this.ms2Spectra == null) {
      this.ms2Spectra = new ArrayList<>();
    }
    this.ms2Spectra.add(ms2SpectraItem);
    return this;
  }

   /**
   * List of MS/MS spectra that belong to this feature.
   * @return ms2Spectra
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MS2_SPECTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<BasicSpectrum> getMs2Spectra() {
    return ms2Spectra;
  }


  @JsonProperty(JSON_PROPERTY_MS2_SPECTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMs2Spectra(List<BasicSpectrum> ms2Spectra) {
    this.ms2Spectra = ms2Spectra;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureImport featureImport = (FeatureImport) o;
    return Objects.equals(this.name, featureImport.name) &&
        Objects.equals(this.externalFeatureId, featureImport.externalFeatureId) &&
        Objects.equals(this.ionMass, featureImport.ionMass) &&
        Objects.equals(this.charge, featureImport.charge) &&
        Objects.equals(this.detectedAdducts, featureImport.detectedAdducts) &&
        Objects.equals(this.rtStartSeconds, featureImport.rtStartSeconds) &&
        Objects.equals(this.rtEndSeconds, featureImport.rtEndSeconds) &&
        Objects.equals(this.rtApexSeconds, featureImport.rtApexSeconds) &&
        Objects.equals(this.mergedMs1, featureImport.mergedMs1) &&
        Objects.equals(this.ms1Spectra, featureImport.ms1Spectra) &&
        Objects.equals(this.ms2Spectra, featureImport.ms2Spectra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, externalFeatureId, ionMass, charge, detectedAdducts, rtStartSeconds, rtEndSeconds, rtApexSeconds, mergedMs1, ms1Spectra, ms2Spectra);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureImport {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    externalFeatureId: ").append(toIndentedString(externalFeatureId)).append("\n");
    sb.append("    ionMass: ").append(toIndentedString(ionMass)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    detectedAdducts: ").append(toIndentedString(detectedAdducts)).append("\n");
    sb.append("    rtStartSeconds: ").append(toIndentedString(rtStartSeconds)).append("\n");
    sb.append("    rtEndSeconds: ").append(toIndentedString(rtEndSeconds)).append("\n");
    sb.append("    rtApexSeconds: ").append(toIndentedString(rtApexSeconds)).append("\n");
    sb.append("    mergedMs1: ").append(toIndentedString(mergedMs1)).append("\n");
    sb.append("    ms1Spectra: ").append(toIndentedString(ms1Spectra)).append("\n");
    sb.append("    ms2Spectra: ").append(toIndentedString(ms2Spectra)).append("\n");
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


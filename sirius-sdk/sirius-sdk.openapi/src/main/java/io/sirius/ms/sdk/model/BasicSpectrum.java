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
import io.sirius.ms.sdk.model.SimplePeak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * BasicSpectrum
 */
@JsonPropertyOrder({
  BasicSpectrum.JSON_PROPERTY_NAME,
  BasicSpectrum.JSON_PROPERTY_MS_LEVEL,
  BasicSpectrum.JSON_PROPERTY_COLLISION_ENERGY,
  BasicSpectrum.JSON_PROPERTY_INSTRUMENT,
  BasicSpectrum.JSON_PROPERTY_PRECURSOR_MZ,
  BasicSpectrum.JSON_PROPERTY_SCAN_NUMBER,
  BasicSpectrum.JSON_PROPERTY_PEAKS,
  BasicSpectrum.JSON_PROPERTY_ABS_INTENSITY_FACTOR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class BasicSpectrum {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_MS_LEVEL = "msLevel";
  private Integer msLevel;

  public static final String JSON_PROPERTY_COLLISION_ENERGY = "collisionEnergy";
  private String collisionEnergy;

  public static final String JSON_PROPERTY_INSTRUMENT = "instrument";
  private String instrument;

  public static final String JSON_PROPERTY_PRECURSOR_MZ = "precursorMz";
  private Double precursorMz;

  public static final String JSON_PROPERTY_SCAN_NUMBER = "scanNumber";
  private Integer scanNumber;

  public static final String JSON_PROPERTY_PEAKS = "peaks";
  private List<SimplePeak> peaks = new ArrayList<>();

  public static final String JSON_PROPERTY_ABS_INTENSITY_FACTOR = "absIntensityFactor";
  private Double absIntensityFactor;

  public BasicSpectrum() {
  }

  public BasicSpectrum name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Optional Displayable name of this spectrum.
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

  public BasicSpectrum msLevel(Integer msLevel) {
    
    this.msLevel = msLevel;
    return this;
  }

   /**
   * MS level of the measured spectrum.  Artificial spectra with no msLevel (e.g. Simulated Isotope patterns) use null or zero
   * @return msLevel
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MS_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMsLevel() {
    return msLevel;
  }


  @JsonProperty(JSON_PROPERTY_MS_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMsLevel(Integer msLevel) {
    this.msLevel = msLevel;
  }

  public BasicSpectrum collisionEnergy(String collisionEnergy) {
    
    this.collisionEnergy = collisionEnergy;
    return this;
  }

   /**
   * Collision energy used for MS/MS spectra  Null for spectra where collision energy is not applicable
   * @return collisionEnergy
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COLLISION_ENERGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCollisionEnergy() {
    return collisionEnergy;
  }


  @JsonProperty(JSON_PROPERTY_COLLISION_ENERGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCollisionEnergy(String collisionEnergy) {
    this.collisionEnergy = collisionEnergy;
  }

  public BasicSpectrum instrument(String instrument) {
    
    this.instrument = instrument;
    return this;
  }

   /**
   * Instrument information.
   * @return instrument
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INSTRUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInstrument() {
    return instrument;
  }


  @JsonProperty(JSON_PROPERTY_INSTRUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstrument(String instrument) {
    this.instrument = instrument;
  }

  public BasicSpectrum precursorMz(Double precursorMz) {
    
    this.precursorMz = precursorMz;
    return this;
  }

   /**
   * Precursor m/z of the MS/MS spectrum  Null for spectra where precursor m/z is not applicable
   * @return precursorMz
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PRECURSOR_MZ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getPrecursorMz() {
    return precursorMz;
  }


  @JsonProperty(JSON_PROPERTY_PRECURSOR_MZ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrecursorMz(Double precursorMz) {
    this.precursorMz = precursorMz;
  }

  public BasicSpectrum scanNumber(Integer scanNumber) {
    
    this.scanNumber = scanNumber;
    return this;
  }

   /**
   * Scan number of the spectrum.  Might be null for artificial spectra with no scan number (e.g. Simulated Isotope patterns or merged spectra)
   * @return scanNumber
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCAN_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getScanNumber() {
    return scanNumber;
  }


  @JsonProperty(JSON_PROPERTY_SCAN_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScanNumber(Integer scanNumber) {
    this.scanNumber = scanNumber;
  }

  public BasicSpectrum peaks(List<SimplePeak> peaks) {
    
    this.peaks = peaks;
    return this;
  }

  public BasicSpectrum addPeaksItem(SimplePeak peaksItem) {
    if (this.peaks == null) {
      this.peaks = new ArrayList<>();
    }
    this.peaks.add(peaksItem);
    return this;
  }

   /**
   * The peaks of this spectrum which might contain additional annotations such as molecular formulas.
   * @return peaks
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PEAKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SimplePeak> getPeaks() {
    return peaks;
  }


  @JsonProperty(JSON_PROPERTY_PEAKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPeaks(List<SimplePeak> peaks) {
    this.peaks = peaks;
  }

  public BasicSpectrum absIntensityFactor(Double absIntensityFactor) {
    
    this.absIntensityFactor = absIntensityFactor;
    return this;
  }

   /**
   * Factor to convert relative intensities to absolute intensities.  Might be null or 1 for spectra where absolute intensities are not available (E.g. artificial or merged spectra)
   * @return absIntensityFactor
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ABS_INTENSITY_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getAbsIntensityFactor() {
    return absIntensityFactor;
  }


  @JsonProperty(JSON_PROPERTY_ABS_INTENSITY_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAbsIntensityFactor(Double absIntensityFactor) {
    this.absIntensityFactor = absIntensityFactor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicSpectrum basicSpectrum = (BasicSpectrum) o;
    return Objects.equals(this.name, basicSpectrum.name) &&
        Objects.equals(this.msLevel, basicSpectrum.msLevel) &&
        Objects.equals(this.collisionEnergy, basicSpectrum.collisionEnergy) &&
        Objects.equals(this.instrument, basicSpectrum.instrument) &&
        Objects.equals(this.precursorMz, basicSpectrum.precursorMz) &&
        Objects.equals(this.scanNumber, basicSpectrum.scanNumber) &&
        Objects.equals(this.peaks, basicSpectrum.peaks) &&
        Objects.equals(this.absIntensityFactor, basicSpectrum.absIntensityFactor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, msLevel, collisionEnergy, instrument, precursorMz, scanNumber, peaks, absIntensityFactor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicSpectrum {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    msLevel: ").append(toIndentedString(msLevel)).append("\n");
    sb.append("    collisionEnergy: ").append(toIndentedString(collisionEnergy)).append("\n");
    sb.append("    instrument: ").append(toIndentedString(instrument)).append("\n");
    sb.append("    precursorMz: ").append(toIndentedString(precursorMz)).append("\n");
    sb.append("    scanNumber: ").append(toIndentedString(scanNumber)).append("\n");
    sb.append("    peaks: ").append(toIndentedString(peaks)).append("\n");
    sb.append("    absIntensityFactor: ").append(toIndentedString(absIntensityFactor)).append("\n");
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


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
import io.sirius.ms.sdk.model.BinaryFingerprint;
import io.sirius.ms.sdk.model.DBLink;
import io.sirius.ms.sdk.model.SpectralLibraryMatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * StructureCandidateFormula
 */
@JsonPropertyOrder({
  StructureCandidateFormula.JSON_PROPERTY_INCHI_KEY,
  StructureCandidateFormula.JSON_PROPERTY_SMILES,
  StructureCandidateFormula.JSON_PROPERTY_STRUCTURE_NAME,
  StructureCandidateFormula.JSON_PROPERTY_XLOG_P,
  StructureCandidateFormula.JSON_PROPERTY_DB_LINKS,
  StructureCandidateFormula.JSON_PROPERTY_SPECTRAL_LIBRARY_MATCHES,
  StructureCandidateFormula.JSON_PROPERTY_RANK,
  StructureCandidateFormula.JSON_PROPERTY_CSI_SCORE,
  StructureCandidateFormula.JSON_PROPERTY_TANIMOTO_SIMILARITY,
  StructureCandidateFormula.JSON_PROPERTY_MCES_DIST_TO_TOP_HIT,
  StructureCandidateFormula.JSON_PROPERTY_FINGERPRINT,
  StructureCandidateFormula.JSON_PROPERTY_MOLECULAR_FORMULA,
  StructureCandidateFormula.JSON_PROPERTY_ADDUCT,
  StructureCandidateFormula.JSON_PROPERTY_FORMULA_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class StructureCandidateFormula {
  public static final String JSON_PROPERTY_INCHI_KEY = "inchiKey";
  private String inchiKey;

  public static final String JSON_PROPERTY_SMILES = "smiles";
  private String smiles;

  public static final String JSON_PROPERTY_STRUCTURE_NAME = "structureName";
  private String structureName;

  public static final String JSON_PROPERTY_XLOG_P = "xlogP";
  private Double xlogP;

  public static final String JSON_PROPERTY_DB_LINKS = "dbLinks";
  private List<DBLink> dbLinks;

  public static final String JSON_PROPERTY_SPECTRAL_LIBRARY_MATCHES = "spectralLibraryMatches";
  private List<SpectralLibraryMatch> spectralLibraryMatches;

  public static final String JSON_PROPERTY_RANK = "rank";
  private Integer rank;

  public static final String JSON_PROPERTY_CSI_SCORE = "csiScore";
  private Double csiScore;

  public static final String JSON_PROPERTY_TANIMOTO_SIMILARITY = "tanimotoSimilarity";
  private Double tanimotoSimilarity;

  public static final String JSON_PROPERTY_MCES_DIST_TO_TOP_HIT = "mcesDistToTopHit";
  private Double mcesDistToTopHit;

  public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
  private BinaryFingerprint fingerprint;

  public static final String JSON_PROPERTY_MOLECULAR_FORMULA = "molecularFormula";
  private String molecularFormula;

  public static final String JSON_PROPERTY_ADDUCT = "adduct";
  private String adduct;

  public static final String JSON_PROPERTY_FORMULA_ID = "formulaId";
  private String formulaId;

  public StructureCandidateFormula() {
  }

  public StructureCandidateFormula inchiKey(String inchiKey) {
    
    this.inchiKey = inchiKey;
    return this;
  }

   /**
   * Get inchiKey
   * @return inchiKey
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INCHI_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInchiKey() {
    return inchiKey;
  }


  @JsonProperty(JSON_PROPERTY_INCHI_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInchiKey(String inchiKey) {
    this.inchiKey = inchiKey;
  }

  public StructureCandidateFormula smiles(String smiles) {
    
    this.smiles = smiles;
    return this;
  }

   /**
   * Get smiles
   * @return smiles
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SMILES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSmiles() {
    return smiles;
  }


  @JsonProperty(JSON_PROPERTY_SMILES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSmiles(String smiles) {
    this.smiles = smiles;
  }

  public StructureCandidateFormula structureName(String structureName) {
    
    this.structureName = structureName;
    return this;
  }

   /**
   * Get structureName
   * @return structureName
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STRUCTURE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStructureName() {
    return structureName;
  }


  @JsonProperty(JSON_PROPERTY_STRUCTURE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStructureName(String structureName) {
    this.structureName = structureName;
  }

  public StructureCandidateFormula xlogP(Double xlogP) {
    
    this.xlogP = xlogP;
    return this;
  }

   /**
   * Get xlogP
   * @return xlogP
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_XLOG_P)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getXlogP() {
    return xlogP;
  }


  @JsonProperty(JSON_PROPERTY_XLOG_P)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setXlogP(Double xlogP) {
    this.xlogP = xlogP;
  }

  public StructureCandidateFormula dbLinks(List<DBLink> dbLinks) {
    
    this.dbLinks = dbLinks;
    return this;
  }

  public StructureCandidateFormula addDbLinksItem(DBLink dbLinksItem) {
    if (this.dbLinks == null) {
      this.dbLinks = new ArrayList<>();
    }
    this.dbLinks.add(dbLinksItem);
    return this;
  }

   /**
   * List of structure database links belonging to this structure candidate  OPTIONAL: needs to be added by parameter
   * @return dbLinks
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DB_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<DBLink> getDbLinks() {
    return dbLinks;
  }


  @JsonProperty(JSON_PROPERTY_DB_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDbLinks(List<DBLink> dbLinks) {
    this.dbLinks = dbLinks;
  }

  public StructureCandidateFormula spectralLibraryMatches(List<SpectralLibraryMatch> spectralLibraryMatches) {
    
    this.spectralLibraryMatches = spectralLibraryMatches;
    return this;
  }

  public StructureCandidateFormula addSpectralLibraryMatchesItem(SpectralLibraryMatch spectralLibraryMatchesItem) {
    if (this.spectralLibraryMatches == null) {
      this.spectralLibraryMatches = new ArrayList<>();
    }
    this.spectralLibraryMatches.add(spectralLibraryMatchesItem);
    return this;
  }

   /**
   * List of spectral library matches belonging to this structure candidate  OPTIONAL: needs to be added by parameter
   * @return spectralLibraryMatches
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SPECTRAL_LIBRARY_MATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SpectralLibraryMatch> getSpectralLibraryMatches() {
    return spectralLibraryMatches;
  }


  @JsonProperty(JSON_PROPERTY_SPECTRAL_LIBRARY_MATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpectralLibraryMatches(List<SpectralLibraryMatch> spectralLibraryMatches) {
    this.spectralLibraryMatches = spectralLibraryMatches;
  }

  public StructureCandidateFormula rank(Integer rank) {
    
    this.rank = rank;
    return this;
  }

   /**
   * the overall rank of this candidate among all candidates of this feature
   * @return rank
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RANK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRank() {
    return rank;
  }


  @JsonProperty(JSON_PROPERTY_RANK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public StructureCandidateFormula csiScore(Double csiScore) {
    
    this.csiScore = csiScore;
    return this;
  }

   /**
   * CSI:FingerID score of the fingerprint of this compound to the predicted fingerprint of CSI:FingerID  This is the score used for ranking structure candidates
   * @return csiScore
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CSI_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getCsiScore() {
    return csiScore;
  }


  @JsonProperty(JSON_PROPERTY_CSI_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCsiScore(Double csiScore) {
    this.csiScore = csiScore;
  }

  public StructureCandidateFormula tanimotoSimilarity(Double tanimotoSimilarity) {
    
    this.tanimotoSimilarity = tanimotoSimilarity;
    return this;
  }

   /**
   * Tanimoto similarly of the fingerprint of this compound to the predicted fingerprint of CSI:FingerID
   * @return tanimotoSimilarity
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TANIMOTO_SIMILARITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getTanimotoSimilarity() {
    return tanimotoSimilarity;
  }


  @JsonProperty(JSON_PROPERTY_TANIMOTO_SIMILARITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTanimotoSimilarity(Double tanimotoSimilarity) {
    this.tanimotoSimilarity = tanimotoSimilarity;
  }

  public StructureCandidateFormula mcesDistToTopHit(Double mcesDistToTopHit) {
    
    this.mcesDistToTopHit = mcesDistToTopHit;
    return this;
  }

   /**
   * Maximum Common Edge Subgraph (MCES) distance to the top scoring hit (CSI:FingerID) in a candidate list.
   * @return mcesDistToTopHit
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MCES_DIST_TO_TOP_HIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMcesDistToTopHit() {
    return mcesDistToTopHit;
  }


  @JsonProperty(JSON_PROPERTY_MCES_DIST_TO_TOP_HIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMcesDistToTopHit(Double mcesDistToTopHit) {
    this.mcesDistToTopHit = mcesDistToTopHit;
  }

  public StructureCandidateFormula fingerprint(BinaryFingerprint fingerprint) {
    
    this.fingerprint = fingerprint;
    return this;
  }

   /**
   * Get fingerprint
   * @return fingerprint
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FINGERPRINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BinaryFingerprint getFingerprint() {
    return fingerprint;
  }


  @JsonProperty(JSON_PROPERTY_FINGERPRINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFingerprint(BinaryFingerprint fingerprint) {
    this.fingerprint = fingerprint;
  }

  public StructureCandidateFormula molecularFormula(String molecularFormula) {
    
    this.molecularFormula = molecularFormula;
    return this;
  }

   /**
   * Molecular formula of this candidate
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

  public StructureCandidateFormula adduct(String adduct) {
    
    this.adduct = adduct;
    return this;
  }

   /**
   * Adduct of this candidate
   * @return adduct
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDUCT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAdduct() {
    return adduct;
  }


  @JsonProperty(JSON_PROPERTY_ADDUCT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdduct(String adduct) {
    this.adduct = adduct;
  }

  public StructureCandidateFormula formulaId(String formulaId) {
    
    this.formulaId = formulaId;
    return this;
  }

   /**
   * Id of the corresponding Formula candidate
   * @return formulaId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FORMULA_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFormulaId() {
    return formulaId;
  }


  @JsonProperty(JSON_PROPERTY_FORMULA_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFormulaId(String formulaId) {
    this.formulaId = formulaId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StructureCandidateFormula structureCandidateFormula = (StructureCandidateFormula) o;
    return Objects.equals(this.inchiKey, structureCandidateFormula.inchiKey) &&
        Objects.equals(this.smiles, structureCandidateFormula.smiles) &&
        Objects.equals(this.structureName, structureCandidateFormula.structureName) &&
        Objects.equals(this.xlogP, structureCandidateFormula.xlogP) &&
        Objects.equals(this.dbLinks, structureCandidateFormula.dbLinks) &&
        Objects.equals(this.spectralLibraryMatches, structureCandidateFormula.spectralLibraryMatches) &&
        Objects.equals(this.rank, structureCandidateFormula.rank) &&
        Objects.equals(this.csiScore, structureCandidateFormula.csiScore) &&
        Objects.equals(this.tanimotoSimilarity, structureCandidateFormula.tanimotoSimilarity) &&
        Objects.equals(this.mcesDistToTopHit, structureCandidateFormula.mcesDistToTopHit) &&
        Objects.equals(this.fingerprint, structureCandidateFormula.fingerprint) &&
        Objects.equals(this.molecularFormula, structureCandidateFormula.molecularFormula) &&
        Objects.equals(this.adduct, structureCandidateFormula.adduct) &&
        Objects.equals(this.formulaId, structureCandidateFormula.formulaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inchiKey, smiles, structureName, xlogP, dbLinks, spectralLibraryMatches, rank, csiScore, tanimotoSimilarity, mcesDistToTopHit, fingerprint, molecularFormula, adduct, formulaId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StructureCandidateFormula {\n");
    sb.append("    inchiKey: ").append(toIndentedString(inchiKey)).append("\n");
    sb.append("    smiles: ").append(toIndentedString(smiles)).append("\n");
    sb.append("    structureName: ").append(toIndentedString(structureName)).append("\n");
    sb.append("    xlogP: ").append(toIndentedString(xlogP)).append("\n");
    sb.append("    dbLinks: ").append(toIndentedString(dbLinks)).append("\n");
    sb.append("    spectralLibraryMatches: ").append(toIndentedString(spectralLibraryMatches)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    csiScore: ").append(toIndentedString(csiScore)).append("\n");
    sb.append("    tanimotoSimilarity: ").append(toIndentedString(tanimotoSimilarity)).append("\n");
    sb.append("    mcesDistToTopHit: ").append(toIndentedString(mcesDistToTopHit)).append("\n");
    sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
    sb.append("    molecularFormula: ").append(toIndentedString(molecularFormula)).append("\n");
    sb.append("    adduct: ").append(toIndentedString(adduct)).append("\n");
    sb.append("    formulaId: ").append(toIndentedString(formulaId)).append("\n");
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


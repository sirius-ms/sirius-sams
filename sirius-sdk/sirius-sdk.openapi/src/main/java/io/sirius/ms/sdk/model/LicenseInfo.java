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
import io.sirius.ms.sdk.model.Subscription;
import io.sirius.ms.sdk.model.SubscriptionConsumables;
import io.sirius.ms.sdk.model.Term;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * LicenseInfo
 */
@JsonPropertyOrder({
  LicenseInfo.JSON_PROPERTY_USER_EMAIL,
  LicenseInfo.JSON_PROPERTY_USER_ID,
  LicenseInfo.JSON_PROPERTY_SUBSCRIPTION,
  LicenseInfo.JSON_PROPERTY_CONSUMABLES,
  LicenseInfo.JSON_PROPERTY_TERMS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class LicenseInfo {
  public static final String JSON_PROPERTY_USER_EMAIL = "userEmail";
  private String userEmail;

  public static final String JSON_PROPERTY_USER_ID = "userId";
  private String userId;

  public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
  private Subscription subscription;

  public static final String JSON_PROPERTY_CONSUMABLES = "consumables";
  private SubscriptionConsumables consumables;

  public static final String JSON_PROPERTY_TERMS = "terms";
  private List<Term> terms;

  public LicenseInfo() {
  }

  public LicenseInfo userEmail(String userEmail) {
    
    this.userEmail = userEmail;
    return this;
  }

   /**
   * Email address of the user account this license information belongs to.
   * @return userEmail
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USER_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUserEmail() {
    return userEmail;
  }


  @JsonProperty(JSON_PROPERTY_USER_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public LicenseInfo userId(String userId) {
    
    this.userId = userId;
    return this;
  }

   /**
   * User ID (uid) of the user account this license information belongs to.
   * @return userId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUserId() {
    return userId;
  }


  @JsonProperty(JSON_PROPERTY_USER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUserId(String userId) {
    this.userId = userId;
  }

  public LicenseInfo subscription(Subscription subscription) {
    
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Subscription getSubscription() {
    return subscription;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

  public LicenseInfo consumables(SubscriptionConsumables consumables) {
    
    this.consumables = consumables;
    return this;
  }

   /**
   * Get consumables
   * @return consumables
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONSUMABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SubscriptionConsumables getConsumables() {
    return consumables;
  }


  @JsonProperty(JSON_PROPERTY_CONSUMABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConsumables(SubscriptionConsumables consumables) {
    this.consumables = consumables;
  }

  public LicenseInfo terms(List<Term> terms) {
    
    this.terms = terms;
    return this;
  }

  public LicenseInfo addTermsItem(Term termsItem) {
    if (this.terms == null) {
      this.terms = new ArrayList<>();
    }
    this.terms.add(termsItem);
    return this;
  }

   /**
   * Get terms
   * @return terms
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TERMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Term> getTerms() {
    return terms;
  }


  @JsonProperty(JSON_PROPERTY_TERMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTerms(List<Term> terms) {
    this.terms = terms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LicenseInfo licenseInfo = (LicenseInfo) o;
    return Objects.equals(this.userEmail, licenseInfo.userEmail) &&
        Objects.equals(this.userId, licenseInfo.userId) &&
        Objects.equals(this.subscription, licenseInfo.subscription) &&
        Objects.equals(this.consumables, licenseInfo.consumables) &&
        Objects.equals(this.terms, licenseInfo.terms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userEmail, userId, subscription, consumables, terms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicenseInfo {\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    consumables: ").append(toIndentedString(consumables)).append("\n");
    sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
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


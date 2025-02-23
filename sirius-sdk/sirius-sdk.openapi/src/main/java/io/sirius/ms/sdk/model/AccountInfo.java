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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AccountInfo
 */
@JsonPropertyOrder({
  AccountInfo.JSON_PROPERTY_USER_I_D,
  AccountInfo.JSON_PROPERTY_USERNAME,
  AccountInfo.JSON_PROPERTY_USER_EMAIL,
  AccountInfo.JSON_PROPERTY_GRAVATAR_U_R_L,
  AccountInfo.JSON_PROPERTY_SUBSCRIPTIONS,
  AccountInfo.JSON_PROPERTY_ACTIVE_SUBSCRIPTION_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class AccountInfo {
  public static final String JSON_PROPERTY_USER_I_D = "userID";
  private String userID;

  public static final String JSON_PROPERTY_USERNAME = "username";
  private String username;

  public static final String JSON_PROPERTY_USER_EMAIL = "userEmail";
  private String userEmail;

  public static final String JSON_PROPERTY_GRAVATAR_U_R_L = "gravatarURL";
  private String gravatarURL;

  public static final String JSON_PROPERTY_SUBSCRIPTIONS = "subscriptions";
  private List<Subscription> subscriptions = new ArrayList<>();

  public static final String JSON_PROPERTY_ACTIVE_SUBSCRIPTION_ID = "activeSubscriptionId";
  private String activeSubscriptionId;

  public AccountInfo() {
  }

  public AccountInfo userID(String userID) {
    
    this.userID = userID;
    return this;
  }

   /**
   * Get userID
   * @return userID
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USER_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUserID() {
    return userID;
  }


  @JsonProperty(JSON_PROPERTY_USER_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUserID(String userID) {
    this.userID = userID;
  }

  public AccountInfo username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUsername() {
    return username;
  }


  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUsername(String username) {
    this.username = username;
  }

  public AccountInfo userEmail(String userEmail) {
    
    this.userEmail = userEmail;
    return this;
  }

   /**
   * Get userEmail
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

  public AccountInfo gravatarURL(String gravatarURL) {
    
    this.gravatarURL = gravatarURL;
    return this;
  }

   /**
   * Get gravatarURL
   * @return gravatarURL
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GRAVATAR_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGravatarURL() {
    return gravatarURL;
  }


  @JsonProperty(JSON_PROPERTY_GRAVATAR_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGravatarURL(String gravatarURL) {
    this.gravatarURL = gravatarURL;
  }

  public AccountInfo subscriptions(List<Subscription> subscriptions) {
    
    this.subscriptions = subscriptions;
    return this;
  }

  public AccountInfo addSubscriptionsItem(Subscription subscriptionsItem) {
    if (this.subscriptions == null) {
      this.subscriptions = new ArrayList<>();
    }
    this.subscriptions.add(subscriptionsItem);
    return this;
  }

   /**
   * Get subscriptions
   * @return subscriptions
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubscriptions(List<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }

  public AccountInfo activeSubscriptionId(String activeSubscriptionId) {
    
    this.activeSubscriptionId = activeSubscriptionId;
    return this;
  }

   /**
   * Get activeSubscriptionId
   * @return activeSubscriptionId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ACTIVE_SUBSCRIPTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getActiveSubscriptionId() {
    return activeSubscriptionId;
  }


  @JsonProperty(JSON_PROPERTY_ACTIVE_SUBSCRIPTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActiveSubscriptionId(String activeSubscriptionId) {
    this.activeSubscriptionId = activeSubscriptionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountInfo accountInfo = (AccountInfo) o;
    return Objects.equals(this.userID, accountInfo.userID) &&
        Objects.equals(this.username, accountInfo.username) &&
        Objects.equals(this.userEmail, accountInfo.userEmail) &&
        Objects.equals(this.gravatarURL, accountInfo.gravatarURL) &&
        Objects.equals(this.subscriptions, accountInfo.subscriptions) &&
        Objects.equals(this.activeSubscriptionId, accountInfo.activeSubscriptionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userID, username, userEmail, gravatarURL, subscriptions, activeSubscriptionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountInfo {\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    gravatarURL: ").append(toIndentedString(gravatarURL)).append("\n");
    sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
    sb.append("    activeSubscriptionId: ").append(toIndentedString(activeSubscriptionId)).append("\n");
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


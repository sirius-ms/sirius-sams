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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * TagGroup
 */
@JsonPropertyOrder({
  TagGroup.JSON_PROPERTY_NAME,
  TagGroup.JSON_PROPERTY_LUCENE_QUERY,
  TagGroup.JSON_PROPERTY_GROUP_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class TagGroup {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_LUCENE_QUERY = "luceneQuery";
  private String luceneQuery;

  public static final String JSON_PROPERTY_GROUP_TYPE = "groupType";
  private String groupType;

  public TagGroup() {
  }

  public TagGroup name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of this Grouping query.
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

  public TagGroup luceneQuery(String luceneQuery) {
    
    this.luceneQuery = luceneQuery;
    return this;
  }

   /**
   * Query used to group the entities in lucene format.
   * @return luceneQuery
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LUCENE_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLuceneQuery() {
    return luceneQuery;
  }


  @JsonProperty(JSON_PROPERTY_LUCENE_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLuceneQuery(String luceneQuery) {
    this.luceneQuery = luceneQuery;
  }

  public TagGroup groupType(String groupType) {
    
    this.groupType = groupType;
    return this;
  }

   /**
   * Get groupType
   * @return groupType
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GROUP_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGroupType() {
    return groupType;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagGroup tagGroup = (TagGroup) o;
    return Objects.equals(this.name, tagGroup.name) &&
        Objects.equals(this.luceneQuery, tagGroup.luceneQuery) &&
        Objects.equals(this.groupType, tagGroup.groupType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, luceneQuery, groupType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagGroup {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    luceneQuery: ").append(toIndentedString(luceneQuery)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
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


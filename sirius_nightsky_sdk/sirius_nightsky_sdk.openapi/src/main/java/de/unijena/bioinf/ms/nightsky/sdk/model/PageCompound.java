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
import de.unijena.bioinf.ms.nightsky.sdk.model.Compound;
import de.unijena.bioinf.ms.nightsky.sdk.model.PageableObject;
import de.unijena.bioinf.ms.nightsky.sdk.model.SortObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PageCompound
 */
@JsonPropertyOrder({
  PageCompound.JSON_PROPERTY_TOTAL_PAGES,
  PageCompound.JSON_PROPERTY_TOTAL_ELEMENTS,
  PageCompound.JSON_PROPERTY_FIRST,
  PageCompound.JSON_PROPERTY_LAST,
  PageCompound.JSON_PROPERTY_SORT,
  PageCompound.JSON_PROPERTY_NUMBER,
  PageCompound.JSON_PROPERTY_NUMBER_OF_ELEMENTS,
  PageCompound.JSON_PROPERTY_PAGEABLE,
  PageCompound.JSON_PROPERTY_SIZE,
  PageCompound.JSON_PROPERTY_CONTENT,
  PageCompound.JSON_PROPERTY_EMPTY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PageCompound {
  public static final String JSON_PROPERTY_TOTAL_PAGES = "totalPages";
  private Integer totalPages;

  public static final String JSON_PROPERTY_TOTAL_ELEMENTS = "totalElements";
  private Long totalElements;

  public static final String JSON_PROPERTY_FIRST = "first";
  private Boolean first;

  public static final String JSON_PROPERTY_LAST = "last";
  private Boolean last;

  public static final String JSON_PROPERTY_SORT = "sort";
  private SortObject sort;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private Integer number;

  public static final String JSON_PROPERTY_NUMBER_OF_ELEMENTS = "numberOfElements";
  private Integer numberOfElements;

  public static final String JSON_PROPERTY_PAGEABLE = "pageable";
  private PageableObject pageable;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public static final String JSON_PROPERTY_CONTENT = "content";
  private List<Compound> content;

  public static final String JSON_PROPERTY_EMPTY = "empty";
  private Boolean empty;

  public PageCompound() { 
  }

  public PageCompound totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

   /**
   * Get totalPages
   * @return totalPages
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TOTAL_PAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotalPages() {
    return totalPages;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_PAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }


  public PageCompound totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

   /**
   * Get totalElements
   * @return totalElements
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TOTAL_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotalElements() {
    return totalElements;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }


  public PageCompound first(Boolean first) {
    this.first = first;
    return this;
  }

   /**
   * Get first
   * @return first
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getFirst() {
    return first;
  }


  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirst(Boolean first) {
    this.first = first;
  }


  public PageCompound last(Boolean last) {
    this.last = last;
    return this;
  }

   /**
   * Get last
   * @return last
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLast() {
    return last;
  }


  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLast(Boolean last) {
    this.last = last;
  }


  public PageCompound sort(SortObject sort) {
    this.sort = sort;
    return this;
  }

   /**
   * Get sort
   * @return sort
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SortObject getSort() {
    return sort;
  }


  @JsonProperty(JSON_PROPERTY_SORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSort(SortObject sort) {
    this.sort = sort;
  }


  public PageCompound number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNumber() {
    return number;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(Integer number) {
    this.number = number;
  }


  public PageCompound numberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
    return this;
  }

   /**
   * Get numberOfElements
   * @return numberOfElements
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NUMBER_OF_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNumberOfElements() {
    return numberOfElements;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER_OF_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }


  public PageCompound pageable(PageableObject pageable) {
    this.pageable = pageable;
    return this;
  }

   /**
   * Get pageable
   * @return pageable
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGEABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PageableObject getPageable() {
    return pageable;
  }


  @JsonProperty(JSON_PROPERTY_PAGEABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageable(PageableObject pageable) {
    this.pageable = pageable;
  }


  public PageCompound size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSize() {
    return size;
  }


  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSize(Integer size) {
    this.size = size;
  }


  public PageCompound content(List<Compound> content) {
    this.content = content;
    return this;
  }

  public PageCompound addContentItem(Compound contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Compound> getContent() {
    return content;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContent(List<Compound> content) {
    this.content = content;
  }


  public PageCompound empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

   /**
   * Get empty
   * @return empty
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMPTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEmpty() {
    return empty;
  }


  @JsonProperty(JSON_PROPERTY_EMPTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }


  /**
   * Return true if this PageCompound object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageCompound pageCompound = (PageCompound) o;
    return Objects.equals(this.totalPages, pageCompound.totalPages) &&
        Objects.equals(this.totalElements, pageCompound.totalElements) &&
        Objects.equals(this.first, pageCompound.first) &&
        Objects.equals(this.last, pageCompound.last) &&
        Objects.equals(this.sort, pageCompound.sort) &&
        Objects.equals(this.number, pageCompound.number) &&
        Objects.equals(this.numberOfElements, pageCompound.numberOfElements) &&
        Objects.equals(this.pageable, pageCompound.pageable) &&
        Objects.equals(this.size, pageCompound.size) &&
        Objects.equals(this.content, pageCompound.content) &&
        Objects.equals(this.empty, pageCompound.empty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalElements, first, last, sort, number, numberOfElements, pageable, size, content, empty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageCompound {\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfElements: ").append(toIndentedString(numberOfElements)).append("\n");
    sb.append("    pageable: ").append(toIndentedString(pageable)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
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

    // add `totalPages` to the URL query string
    if (getTotalPages() != null) {
      joiner.add(String.format("%stotalPages%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTotalPages()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `totalElements` to the URL query string
    if (getTotalElements() != null) {
      joiner.add(String.format("%stotalElements%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTotalElements()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `first` to the URL query string
    if (getFirst() != null) {
      joiner.add(String.format("%sfirst%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFirst()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `last` to the URL query string
    if (getLast() != null) {
      joiner.add(String.format("%slast%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getLast()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `sort` to the URL query string
    if (getSort() != null) {
      joiner.add(getSort().toUrlQueryString(prefix + "sort" + suffix));
    }

    // add `number` to the URL query string
    if (getNumber() != null) {
      joiner.add(String.format("%snumber%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumber()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `numberOfElements` to the URL query string
    if (getNumberOfElements() != null) {
      joiner.add(String.format("%snumberOfElements%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumberOfElements()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `pageable` to the URL query string
    if (getPageable() != null) {
      joiner.add(getPageable().toUrlQueryString(prefix + "pageable" + suffix));
    }

    // add `size` to the URL query string
    if (getSize() != null) {
      joiner.add(String.format("%ssize%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSize()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `content` to the URL query string
    if (getContent() != null) {
      for (int i = 0; i < getContent().size(); i++) {
        if (getContent().get(i) != null) {
          joiner.add(getContent().get(i).toUrlQueryString(String.format("%scontent%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `empty` to the URL query string
    if (getEmpty() != null) {
      joiner.add(String.format("%sempty%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEmpty()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}


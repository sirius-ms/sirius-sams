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

package de.unijena.bioinf.ms.nightsky.sdk.api;

import de.unijena.bioinf.ms.nightsky.sdk.client.ApiClient;
import de.unijena.bioinf.ms.nightsky.sdk.client.ApiException;
import de.unijena.bioinf.ms.nightsky.sdk.client.ApiResponse;
import de.unijena.bioinf.ms.nightsky.sdk.client.Pair;

import de.unijena.bioinf.ms.nightsky.sdk.model.AccountCredentials;
import de.unijena.bioinf.ms.nightsky.sdk.model.AccountInfo;
import de.unijena.bioinf.ms.nightsky.sdk.model.Subscription;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LoginAndAccountApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public LoginAndAccountApi() {
    this(new ApiClient());
  }

  public LoginAndAccountApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Get information about the account currently logged in.
   * Get information about the account currently logged in. Fails if not logged in.
   * @param includeSubs include available and active subscriptions in {@link AccountInfo AccountInfo}. (optional, default to false)
   * @return AccountInfo
   * @throws ApiException if fails to make API call
   */
  public AccountInfo getAccountInfo(Boolean includeSubs) throws ApiException {
    ApiResponse<AccountInfo> localVarResponse = getAccountInfoWithHttpInfo(includeSubs);
    return localVarResponse.getData();
  }

  /**
   * Get information about the account currently logged in.
   * Get information about the account currently logged in. Fails if not logged in.
   * @param includeSubs include available and active subscriptions in {@link AccountInfo AccountInfo}. (optional, default to false)
   * @return ApiResponse&lt;AccountInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<AccountInfo> getAccountInfoWithHttpInfo(Boolean includeSubs) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAccountInfoRequestBuilder(includeSubs);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAccountInfo", localVarResponse);
        }
        return new ApiResponse<AccountInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AccountInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAccountInfoRequestBuilder(Boolean includeSubs) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "includeSubs";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("includeSubs", includeSubs));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get SignUp URL (For signUp via web browser)
   * Get SignUp URL (For signUp via web browser)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getSignUpURL() throws ApiException {
    ApiResponse<String> localVarResponse = getSignUpURLWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Get SignUp URL (For signUp via web browser)
   * Get SignUp URL (For signUp via web browser)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> getSignUpURLWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSignUpURLRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSignUpURL", localVarResponse);
        }
        // for plain text response
        if (localVarResponse.headers().map().containsKey("Content-Type") &&
                "text/plain".equalsIgnoreCase(localVarResponse.headers().map().get("Content-Type").get(0).split(";")[0].trim())) {
          java.util.Scanner s = new java.util.Scanner(localVarResponse.body()).useDelimiter("\\A");
          String responseBodyText = s.hasNext() ? s.next() : "";
          return new ApiResponse<String>(
                  localVarResponse.statusCode(),
                  localVarResponse.headers().map(),
                  responseBodyText
          );
        } else {
            throw new RuntimeException("Error! The response Content-Type is supposed to be `text/plain` but it's not: " + localVarResponse);
        }
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSignUpURLRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/signUpURL";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "text/plain;charset&#x3D;UTF-8");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get available subscriptions of the account currently logged in.
   * Get available subscriptions of the account currently logged in. Fails if not logged in.
   * @return List&lt;Subscription&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Subscription> getSubscriptions() throws ApiException {
    ApiResponse<List<Subscription>> localVarResponse = getSubscriptionsWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Get available subscriptions of the account currently logged in.
   * Get available subscriptions of the account currently logged in. Fails if not logged in.
   * @return ApiResponse&lt;List&lt;Subscription&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<Subscription>> getSubscriptionsWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubscriptionsRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubscriptions", localVarResponse);
        }
        return new ApiResponse<List<Subscription>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<Subscription>>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubscriptionsRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/subscriptions";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Check if a user is logged in.
   * Check if a user is logged in.
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean isLoggedIn() throws ApiException {
    ApiResponse<Boolean> localVarResponse = isLoggedInWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Check if a user is logged in.
   * Check if a user is logged in.
   * @return ApiResponse&lt;Boolean&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Boolean> isLoggedInWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = isLoggedInRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("isLoggedIn", localVarResponse);
        }
        return new ApiResponse<Boolean>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Boolean>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder isLoggedInRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/isLoggedIn";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Login into SIRIUS web services and activate default subscription if available.
   * Login into SIRIUS web services and activate default subscription if available.
   * @param acceptTerms  (required)
   * @param accountCredentials used to log in. (required)
   * @param failWhenLoggedIn if true request fails if an active login already exists. (optional, default to false)
   * @param includeSubs include available and active subscriptions in {@link AccountInfo AccountInfo}. (optional, default to false)
   * @return AccountInfo
   * @throws ApiException if fails to make API call
   */
  public AccountInfo login(Boolean acceptTerms, AccountCredentials accountCredentials, Boolean failWhenLoggedIn, Boolean includeSubs) throws ApiException {
    ApiResponse<AccountInfo> localVarResponse = loginWithHttpInfo(acceptTerms, accountCredentials, failWhenLoggedIn, includeSubs);
    return localVarResponse.getData();
  }

  /**
   * Login into SIRIUS web services and activate default subscription if available.
   * Login into SIRIUS web services and activate default subscription if available.
   * @param acceptTerms  (required)
   * @param accountCredentials used to log in. (required)
   * @param failWhenLoggedIn if true request fails if an active login already exists. (optional, default to false)
   * @param includeSubs include available and active subscriptions in {@link AccountInfo AccountInfo}. (optional, default to false)
   * @return ApiResponse&lt;AccountInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<AccountInfo> loginWithHttpInfo(Boolean acceptTerms, AccountCredentials accountCredentials, Boolean failWhenLoggedIn, Boolean includeSubs) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = loginRequestBuilder(acceptTerms, accountCredentials, failWhenLoggedIn, includeSubs);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("login", localVarResponse);
        }
        return new ApiResponse<AccountInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AccountInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder loginRequestBuilder(Boolean acceptTerms, AccountCredentials accountCredentials, Boolean failWhenLoggedIn, Boolean includeSubs) throws ApiException {
    // verify the required parameter 'acceptTerms' is set
    if (acceptTerms == null) {
      throw new ApiException(400, "Missing the required parameter 'acceptTerms' when calling login");
    }
    // verify the required parameter 'accountCredentials' is set
    if (accountCredentials == null) {
      throw new ApiException(400, "Missing the required parameter 'accountCredentials' when calling login");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/login";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "acceptTerms";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("acceptTerms", acceptTerms));
    localVarQueryParameterBaseName = "failWhenLoggedIn";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("failWhenLoggedIn", failWhenLoggedIn));
    localVarQueryParameterBaseName = "includeSubs";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("includeSubs", includeSubs));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(accountCredentials);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Logout from SIRIUS web services.
   * Logout from SIRIUS web services.
   * @throws ApiException if fails to make API call
   */
  public void logout() throws ApiException {
    logoutWithHttpInfo();
  }

  /**
   * Logout from SIRIUS web services.
   * Logout from SIRIUS web services.
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> logoutWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = logoutRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("logout", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder logoutRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/logout";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Open User portal in browser.
   * Open User portal in browser. If user is logged in SIRIUS tries to transfer the login state to the browser.
   * @throws ApiException if fails to make API call
   */
  public void openPortal() throws ApiException {
    openPortalWithHttpInfo();
  }

  /**
   * Open User portal in browser.
   * Open User portal in browser. If user is logged in SIRIUS tries to transfer the login state to the browser.
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> openPortalWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = openPortalRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("openPortal", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder openPortalRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/openPortal";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Select a subscription as active subscription to be used for computations.
   * Select a subscription as active subscription to be used for computations.
   * @param sid  (required)
   * @return AccountInfo
   * @throws ApiException if fails to make API call
   */
  public AccountInfo selectSubscription(String sid) throws ApiException {
    ApiResponse<AccountInfo> localVarResponse = selectSubscriptionWithHttpInfo(sid);
    return localVarResponse.getData();
  }

  /**
   * Select a subscription as active subscription to be used for computations.
   * Select a subscription as active subscription to be used for computations.
   * @param sid  (required)
   * @return ApiResponse&lt;AccountInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<AccountInfo> selectSubscriptionWithHttpInfo(String sid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = selectSubscriptionRequestBuilder(sid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("selectSubscription", localVarResponse);
        }
        return new ApiResponse<AccountInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AccountInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder selectSubscriptionRequestBuilder(String sid) throws ApiException {
    // verify the required parameter 'sid' is set
    if (sid == null) {
      throw new ApiException(400, "Missing the required parameter 'sid' when calling selectSubscription");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/subscriptions/select-active";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "sid";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sid", sid));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Open SignUp window in system browser and return signUp link.
   * Open SignUp window in system browser and return signUp link.
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String signUp() throws ApiException {
    ApiResponse<String> localVarResponse = signUpWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Open SignUp window in system browser and return signUp link.
   * Open SignUp window in system browser and return signUp link.
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> signUpWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = signUpRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("signUp", localVarResponse);
        }
        // for plain text response
        if (localVarResponse.headers().map().containsKey("Content-Type") &&
                "text/plain".equalsIgnoreCase(localVarResponse.headers().map().get("Content-Type").get(0).split(";")[0].trim())) {
          java.util.Scanner s = new java.util.Scanner(localVarResponse.body()).useDelimiter("\\A");
          String responseBodyText = s.hasNext() ? s.next() : "";
          return new ApiResponse<String>(
                  localVarResponse.statusCode(),
                  localVarResponse.headers().map(),
                  responseBodyText
          );
        } else {
            throw new RuntimeException("Error! The response Content-Type is supposed to be `text/plain` but it's not: " + localVarResponse);
        }
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder signUpRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/account/signUp";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "text/plain;charset&#x3D;UTF-8");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}

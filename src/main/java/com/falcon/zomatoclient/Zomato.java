package com.falcon.zomatoclient;

import com.falcon.zomatoclient.domain.common.GeoCode;
import com.falcon.zomatoclient.domain.common.LocationDetails;
import com.falcon.zomatoclient.domain.common.Restaurant;
import com.falcon.zomatoclient.domain.restaurant.DailyMenus;
import com.falcon.zomatoclient.domain.restaurant.EntityType;
import com.falcon.zomatoclient.domain.restaurant.OrderOption;
import com.falcon.zomatoclient.domain.restaurant.SearchRestaurantResult;
import com.falcon.zomatoclient.domain.restaurant.SortOption;
import com.falcon.zomatoclient.domain.result.CategoriesList;
import com.falcon.zomatoclient.domain.result.CitiesResult;
import com.falcon.zomatoclient.domain.result.CollectionsResult;
import com.falcon.zomatoclient.domain.result.ReviewsResult;
import com.falcon.zomatoclient.domain.result.SearchLocationResult;
import com.falcon.zomatoclient.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  06/07/16. <br/> Updated on 06/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Slf4j
public class Zomato {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();
    private final String apiKey;
    private final String zomatoHost;

    public Zomato(final HttpClient httpClient, final String apiKey, final String zomatoHost) {
        this.httpClient = httpClient;
        this.apiKey = apiKey;
        this.zomatoHost = zomatoHost;
    }

    public Zomato(final String apiKey, final String zomatoHost) {
        this.httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setRedirectsEnabled(true)
                        .build())
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .setMaxConnPerRoute(20)
                .setMaxConnTotal(20)
                .build();
        this.apiKey = apiKey;
        this.zomatoHost = zomatoHost;
    }

    /**
     * Get Categories available on zomato.
     *
     * @return Categories
     */
    public CategoriesList getCategories() throws HttpException {
        log.debug("Entering Zomato:getCategories");
        String url = this.zomatoHost + "/categories";
        CategoriesList categories;
        try {
            HttpResponse httpResponse = sendGet(url, null, null);
            categories = objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), CategoriesList.class);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get categories." : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getCategories with {}", categories);
        return categories;
    }

    /**
     * Get cities where zomato is present.
     *
     * @param q       query city
     * @param lat     latitude
     * @param lon     longitude
     * @param cityIds numerical city ids
     * @param count   per page result count
     * @return CitiesResult
     */
    public CitiesResult getCities(final String q, final Double lat, final Double lon, final List<String> cityIds, final
    Integer count) throws HttpException {
        log.debug("Entering Zomato:getCities with q={}, lat={}, lon={}, cityIds={}, count={}",
                q, lat, lon, cityIds, count);
        String url = this.zomatoHost + "/cities";
        CitiesResult cities;
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (!StringUtils.isEmpty(q)) queryParams.put("q", q);
            if (lat != null) queryParams.put("lat", String.valueOf(lat));
            if (lon != null) queryParams.put("lon", String.valueOf(lon));
            if (cityIds != null) queryParams.put("city_ids", String.join(",", cityIds));
            if (count != null && count > 0) queryParams.put("count", String.valueOf(count));

            HttpResponse httpResponse = sendGet(url, null, queryParams);
            cities = objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), CitiesResult.class);
            log.info("got cities {}", cities);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get cities" : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getCities with {}", cities);
        return cities;
    }

    /**
     * Get Collections based on query parameters
     *
     * @param cityId integer id of city
     * @param lat    latitude
     * @param lon    longitude
     * @param count  count of result per page
     * @return list of <Collection></Collection>
     */
    public CollectionsResult getCollections(final Integer cityId, final Double lat, final Double lon, final Integer
            count) throws HttpException {
        log.debug("Entering Zomato:getCollections with cityId={}, lat={}, lon={}, count={}");
        String url = this.zomatoHost + "/collections";
        CollectionsResult collections;
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (cityId != null) queryParams.put("city_id", String.valueOf(cityId));
            if (lat != null) queryParams.put("lat", String.valueOf(lat));
            if (lon != null) queryParams.put("lon", String.valueOf(lon));
            if (count != null) queryParams.put("count", String.valueOf(count));

            HttpResponse httpResponse = sendGet(url, null, queryParams);
            collections = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()),
                    CollectionsResult.class);
            log.info("Got collections {}", collections);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get collections" : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getCollections with {}", collections);
        return collections;
    }

    /**
     * This method returns geo code for a given pair of lat, lon.
     *
     * @param lat latitude
     * @param lon longitude
     * @return GeoCode for given lat, lon.
     */
    public GeoCode getGeoCode(final Double lat, final Double lon) throws HttpException {
        log.debug("Entering Zomato:getGeoCode with lat={}, lon={}", lat, lon);
        String url = this.zomatoHost + "/geocode";
        GeoCode geoCode;
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (lat != null) queryParams.put("lat", String.valueOf(lat));
            if (lon != null) queryParams.put("lon", String.valueOf(lon));
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            geoCode = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()), GeoCode.class);
            log.info("Got geocode {}", geoCode);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get geoCode" : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getGeoCode with {}", geoCode);
        return geoCode;
    }

    /**
     * This method returns location details.
     *
     * @param entityId   location id
     * @param entityType location type
     * @return LocationDetails
     */
    public LocationDetails getLocationDetails(final Integer entityId, final String entityType) throws HttpException {
        log.debug("Entering Zomato:getLocationDetails with entityId={} and entityType={}", entityId, entityType);
        LocationDetails locationDetails;
        String url = this.zomatoHost + "/location_details";
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (entityId != null) queryParams.put("entity_id", String.valueOf(entityId));
            if (entityType != null) queryParams.put("entity_type", entityType);
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            locationDetails = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()),
                    LocationDetails.class);
            log.info("Got LocationDetails {}", locationDetails);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get location details" : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getLocationDetails with {}", locationDetails);
        return locationDetails;
    }

    /**
     * This method searches for zomato locations by keyword. Provide coordinates for better result.
     *
     * @param query     keyword to search for.
     * @param latitude  latitude of location.
     * @param longitude longitude of location.
     * @param count     max number of results to fetch.
     * @return Locality
     */
    public SearchLocationResult searchLocations(final String query, final Double latitude, final Double longitude,
                                                final int count) throws HttpException {
        log.debug("Entering Zomato:searchLocations with query={}, latitude={}, longitude={}, count={}", query,
                latitude, longitude, count);
        String url = this.zomatoHost + "/locations";
        SearchLocationResult locality;
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (!StringUtils.isEmpty(query)) queryParams.put("query", query);
            if (latitude != null) queryParams.put("lat", String.valueOf(latitude));
            if (longitude != null) queryParams.put("lon", String.valueOf(longitude));
            if (count > 0) queryParams.put("count", String.valueOf(count));
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            locality = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()),
                    SearchLocationResult.class);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to search locations" : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:searchLocations with {}", locality);
        return locality;
    }

    /**
     * Get the dailymenu of restaurant by id.
     *
     * @param restaurantId restaurant Id
     * @return DailyMenus
     */
    public DailyMenus getDailyMenusOfRestaurant(final int restaurantId) throws HttpException {
        log.debug("Entering Zomato:getDailyMenusOfRestaurant with restaurantId={}", restaurantId);
        DailyMenus dailyMenus;
        String url = this.zomatoHost + "/dailymenu";
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            queryParams.put("res_id", String.valueOf(restaurantId));
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
            dailyMenus = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()), DailyMenus.class);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get dailymenu of restaurant with id " +
                    restaurantId : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getDailyMenusOfRestaurant with {}", dailyMenus);
        return dailyMenus;
    }

    /**
     * Get the restaurant by Id.
     *
     * @param restaurantId restaurant id.
     * @return Restaurant
     */
    public Restaurant getRestaurantById(final int restaurantId) throws HttpException {
        log.debug("Entering Zomato:getRestaurantById with restaurantId={}", restaurantId);
        Restaurant restaurant;
        String url = this.zomatoHost + "/restaurant";
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            queryParams.put("res_id", String.valueOf(restaurantId));
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            restaurant = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()), Restaurant.class);
        } catch (IOException | URISyntaxException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get restaurant with id " + restaurantId : e
                    .getMessage(), e);
        }
        log.debug("Exiting Zomato:getRestaurantById with {}", restaurant);
        return restaurant;
    }

    /**
     * Get the reviews of a restaurant by Id.
     *
     * @param restaurantId restaurant id.
     * @param offset       offset of results.
     * @param count        number of results to fetch.
     * @return List of reviews.
     */
    public ReviewsResult getReviewsOfRestaurant(final int restaurantId, final int offset, final int count) throws
            HttpException {
        log.debug("Entering Zomato:getReviewsOfRestaurant with restaurantId={}", restaurantId);
        ReviewsResult reviews;
        String url = this.zomatoHost + "/reviews";
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            queryParams.put("res_id", String.valueOf(restaurantId));
            queryParams.put("start", String.valueOf(offset));
            queryParams.put("count", String.valueOf(count));
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            reviews = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()), ReviewsResult.class);
        } catch (IOException | URISyntaxException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to get reviews for restaurant with id " +
                    restaurantId : e.getMessage(), e);
        }
        log.debug("Exiting Zomato:getReviewsOfRestaurant with {}", reviews);
        return reviews;
    }

    /**
     * Search restaurants on zomato.
     *
     * @return SearchRestaurantResult
     */
    public SearchRestaurantResult searchRestaurants(final Integer entityId, final EntityType entityType, final String
            query, final Integer start, final Integer count, final Double latitude, final Double longitude, final Double
                                                            radius, List<Integer> cuisineIds, final Integer establishmentId, final Integer collectionId, final Integer
                                                            categoryId, final SortOption sort, final OrderOption order) throws HttpException {
        log.debug("Entering Zomato:searchRestaurants with entityId={}, entityType={}, query={}, start={}, count={}, " +
                        "latitude={}, longitude={}, radius={}, cuisineIds={}, establishmentId={}, collectionId={}, " +
                        "categoryId={}, sort={}, order={}", entityId, entityType, query, start, count, latitude, longitude,
                radius, cuisineIds, establishmentId, collectionId, categoryId, sort, order);
        SearchRestaurantResult result;
        String url = this.zomatoHost + "/search";
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            if (entityId != null) queryParams.put("entityId", String.valueOf(entityId));
            if (entityType != null) queryParams.put("entity_type", entityType.toString());
            if (!StringUtils.isEmpty(query)) queryParams.put("q", query);
            if (start == null) {
                queryParams.put("start", "0");
            } else {
                queryParams.put("start", String.valueOf(start));
            }
            if (count == null) {
                queryParams.put("count", "20");
            } else {
                queryParams.put("count", String.valueOf(start));
            }
            if (latitude != null) queryParams.put("lat", String.valueOf(latitude));
            if (longitude != null) queryParams.put("lon", String.valueOf(longitude));
            if (radius != null) {
                queryParams.put("radius", String.valueOf(radius));
            } else {
                queryParams.put("radius", "10.0");
            }
            if (cuisineIds != null && !cuisineIds.isEmpty()) {
                queryParams.put("cuisines", cuisineIds.stream().map(Object::toString).collect(Collectors.joining(",")));
            }
            if (establishmentId != null) {
                queryParams.put("establishment_type", String.valueOf(establishmentId));
            }
            if (collectionId != null) queryParams.put("collection_id", String.valueOf(collectionId));
            if (categoryId != null) queryParams.put("category", String.valueOf(categoryId));
            if (sort != null) queryParams.put("sort", sort.toString());
            if (order != null) queryParams.put("order", order.toString());
            HttpResponse httpResponse = sendGet(url, null, queryParams);
            result = objectMapper.readValue(EntityUtils.toByteArray(httpResponse.getEntity()), SearchRestaurantResult
                    .class);
        } catch (URISyntaxException | IOException e) {
            throw new HttpException(e.getMessage() == null ? "Failed to search restaurant with given parameters" : e
                    .getMessage());
        }
        log.debug("Exiting searchRestaurants with {}", result);
        return result;
    }

    private HttpResponse sendGet(final String url, final HashMap<String, String> headers,
                                 final HashMap<String, String> queryParams) throws URISyntaxException, IOException,
            HttpException {
        URI uri = prepareUri(url, queryParams);
        HttpGet httpGet = new HttpGet(uri);
        prepareRequest(httpGet, headers);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() < 200 || httpResponse.getStatusLine().getStatusCode() >= 300) {
            EntityUtils.consumeQuietly(httpResponse.getEntity());
            throw new HttpResponseException(httpResponse.getStatusLine().getStatusCode(), "Request failed: " +
                    (httpResponse.getEntity() != null ? EntityUtils.toString(httpResponse.getEntity()) : null));
        }
        return httpResponse;
    }

    private HttpResponse sendPut(final String url, final byte[] requestBody, final HashMap<String, String> headers,
                                 final HashMap<String, String> queryParams) throws URISyntaxException, IOException {
        URI uri = prepareUri(url, queryParams);
        HttpPut httpPut = new HttpPut(uri);
        prepareRequest(httpPut, requestBody, headers);
        HttpResponse httpResponse = httpClient.execute(httpPut);
        if (httpResponse.getStatusLine().getStatusCode() < 200 || httpResponse.getStatusLine().getStatusCode() >= 300) {
            EntityUtils.consumeQuietly(httpResponse.getEntity());
            throw new HttpResponseException(httpResponse.getStatusLine().getStatusCode(), "Request failed: " +
                    (httpResponse.getEntity() != null ? EntityUtils.toString(httpResponse.getEntity()) : null));
        }
        return httpResponse;
    }

    private HttpResponse sendPost(final String url, final byte[] requestBody, final HashMap<String, String> headers,
                                  final HashMap<String, String> queryParams) throws URISyntaxException, IOException {
        URI uri = prepareUri(url, queryParams);
        HttpPost httpPost = new HttpPost(uri);
        prepareRequest(httpPost, requestBody, headers);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() < 200 || httpResponse.getStatusLine().getStatusCode() >= 300) {
            EntityUtils.consumeQuietly(httpResponse.getEntity());
            throw new HttpResponseException(httpResponse.getStatusLine().getStatusCode(), "Request failed: " +
                    (httpResponse.getEntity() != null ? EntityUtils.toString(httpResponse.getEntity()) : null));
        }
        return httpResponse;
    }

    private URI prepareUri(final String url, final HashMap<String, String> queryParams) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (queryParams != null) {
            queryParams.forEach(uriBuilder::addParameter);
        }
        return uriBuilder.build();
    }

    private void prepareRequest(HttpEntityEnclosingRequestBase request, byte[] requestBody,
                                HashMap<String, String> headers) {
        if (requestBody != null) {
            request.setEntity(new ByteArrayEntity(requestBody));
        } else {
            request.setEntity(new ByteArrayEntity(new byte[]{}));
        }
        if (headers != null) {
            headers.forEach((k, v) -> request.addHeader(new BasicHeader(k, v)));
        }
    }

    private void prepareRequest(HttpRequestBase request, HashMap<String, String> headers) {
        if (headers != null) {
            headers.forEach((k, v) -> request.addHeader(new BasicHeader(k, v)));
        }
        request.addHeader(new BasicHeader("user-key", apiKey));
    }
}

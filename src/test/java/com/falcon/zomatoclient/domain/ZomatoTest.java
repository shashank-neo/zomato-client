package com.falcon.zomatoclient.domain;

import com.falcon.zomatoclient.Zomato;
import com.falcon.zomatoclient.domain.common.GeoCode;
import com.falcon.zomatoclient.domain.common.LocationDetails;
import com.falcon.zomatoclient.domain.common.Restaurant;
import com.falcon.zomatoclient.domain.restaurant.DailyMenus;
import com.falcon.zomatoclient.domain.restaurant.EntityType;
import com.falcon.zomatoclient.domain.restaurant.SearchRestaurantResult;
import com.falcon.zomatoclient.domain.result.CategoriesList;
import com.falcon.zomatoclient.domain.result.CitiesResult;
import com.falcon.zomatoclient.domain.result.CollectionsResult;
import com.falcon.zomatoclient.domain.result.ReviewsResult;
import com.falcon.zomatoclient.domain.result.SearchLocationResult;

import org.apache.http.HttpException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public class ZomatoTest {
    //fill the key here to run integration tests.
    private final Zomato zomato = new Zomato("<YOUR-KEY>",
            "https://developers.zomato.com/api/v2.1");

    @Test
    public void testGetCategories() throws HttpException {
        CategoriesList categories = zomato.getCategories();
        assertNotNull(categories);
    }

    @Test
    public void testGetCities() throws HttpException {
        CitiesResult cities = zomato.getCities("bakery", null, null, null, 10);
        assertNotNull(cities);
    }

    @Test
    public void testGetCollections() throws HttpException {
        CollectionsResult collections = zomato.getCollections(1597, null, null, 10);
        assertNotNull(collections);
    }

    @Test
    public void testGetGeoCode() throws HttpException {
        GeoCode geoCode = zomato.getGeoCode(12.97, 77.59);
        assertNotNull(geoCode);
    }

    @Test
    public void testGetLocationDetails() throws HttpException {
        LocationDetails locationDetails = zomato.getLocationDetails(36932, "group");
        assertNotNull(locationDetails);
    }

    @Test
    public void testSearchLocation() throws HttpException {
        SearchLocationResult locationResult = zomato.searchLocations("bangalore", null, null, 10);
        assertNotNull(locationResult);
    }

    //@Test
    public void testGetDailyMenusOfRestaurant() throws HttpException {
        DailyMenus menu = zomato.getDailyMenusOfRestaurant(16765367);
        assertNotNull(menu);
    }

    @Test
    public void testGetRestaurantById() throws HttpException {
        Restaurant restaurant = zomato.getRestaurantById(16765367);
        assertNotNull(restaurant);
    }

    @Test
    public void testGetReviewsOfRestaurant() throws HttpException {
        ReviewsResult reviewsResult = zomato.getReviewsOfRestaurant(16765367, 0, 10);
        assertNotNull(reviewsResult);
    }

    @Test
    public void testSearchRestaurants() throws HttpException {
        SearchRestaurantResult result = zomato.searchRestaurants(null, EntityType.CITY, "bangalore", null, null,
                null, null, null, null, null, null, null, null, null);
        assertNotNull(result);
    }
}

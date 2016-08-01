package com.falcon.zomatoclient.domain.common;

import com.falcon.zomatoclient.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public class CommonDeserializationTest {
    private final ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();

    @Test
    public void testCategoryCreateFromString() throws IOException {
        String categoryString = "{\"id\":\"3\",\"name\":\"Nightlife\"}";
        Category category = objectMapper.readValue(categoryString, Category.class);
        assertEquals(category.getId(), 3L);
        assertEquals(category.getName(), "Nightlife");
    }

    @Test
    public void testCityCreateFromString() throws IOException {
        String cityString = "{\"id\":\"280\",\"name\":\"New York City, NY\",\"country_id\":\"216\"," +
                "\"country_name\":\"United States\",\"is_state\":\"0\",\"state_id\":\"103\"," +
                "\"state_name\":\"New York State\",\"state_code\":\"NY\"}";
        City city = objectMapper.readValue(cityString, City.class);
        assertEquals(city.getId(), 280L);
        assertEquals(city.isState(), false);
    }

    @Test
    public void testCollectionCreateFromString() throws IOException {
        String collectionString = "{\"collection_id\":\"1\",\"title\":\"Trending this week\"," +
                "\"url\":\"https://www.zomato.com/new-york-city/top-restaurants\",\"description\":\"The most popular " +
                "restaurants in town this week\",\"image_url\":\"https://b.zmtcdn.com/data/collections/" +
                "e40960514831cb9b74c552d69eceee0f_1418387628_l.jpg\",\"res_count\":\"30\"," +
                "\"share_url\":\"http://www.zoma.to/c-280/1\"}";
        Collection collection = objectMapper.readValue(collectionString, Collection.class);
        assertEquals(collection.getCollectionId(), 1L);
        assertEquals(collection.getResCount(), 30);
        assertEquals(collection.getTitle(), "Trending this week");
    }

    @Test
    public void testCreateCuisineFromString() throws IOException {
        String cuisineString = "{\"cuisine_id\":\"25\",\"cuisine_name\":\"Chinese\"}";
        Cuisine cuisine = objectMapper.readValue(cuisineString, Cuisine.class);
        assertEquals(cuisine.getCuisineId(), 25);
        assertEquals(cuisine.getCuisineName(), "Chinese");

    }

    @Test
    public void testCreateEstablishmentFromString() throws IOException {
        String establishmentString = "{\"establishment_id\":\"31\",\"establishment_name\":\"Bakery\"}";
        Establishment establishment = objectMapper.readValue(establishmentString, Establishment.class);
        assertEquals(establishment.getEstablishmentId(), 31);
        assertEquals(establishment.getEstablishmentName(), "Bakery");
    }

    @Test
    public void testCreateGeoCodeFromString() throws IOException {
        String geoCodeString = "{\"location\":{\"entity_type\":\"\",\"entity_id\":0,\"title\":\"Richmond Road\"," +
                "\"latitude\":\"12.9664300000\",\"longitude\":\"77.6072820000\",\"city_id\":4,\"city_name\":\"Bangalore\",\"country_id\":1,\"country_name\":\"India\"},\"popularity\":{\"popularity\":\"4.84\",\"nightlife_index\":\"5.00\",\"nearby_res\":[\"60587\",\"54097\",\"50890\",\"57750\",\"57438\",\"50407\",\"51038\",\"18022249\",\"18339874\"],\"top_cuisines\":[\"North Indian\",\"Chinese\",\"Fast Food\",\"Continental\",\"South Indian\"],\"popularity_res\":\"100\",\"nightlife_res\":\"10\",\"subzone\":\"Richmond Road\",\"subzone_id\":5101,\"city\":\"Bangalore\"},\"link\":\"https://www.zomato.com/bangalore/richmond-road-restaurants?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"nearby_restaurants\":{\"1\":{\"restaurant\":{\"R\":{\"res_id\":60587},\"apikey\":\"f8127748b93648c2b92d64c70be35d0c\",\"id\":\"60587\",\"name\":\"Smally's Resto Cafe\",\"url\":\"https://www.zomato.com/bangalore/smallys-resto-cafe-church-street?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"location\":{\"address\":\"1 A, Church street, Opposite Starbucks Coffee, Church Street, Bangalore\",\"locality\":\"Church Street\",\"city\":\"Bangalore\",\"city_id\":4,\"latitude\":\"12.9743836956\",\"longitude\":\"77.6073561609\",\"zipcode\":\"560001\",\"country_id\":1},\"cuisines\":\"American, Italian, Burger\",\"average_cost_for_two\":850,\"price_range\":2,\"currency\":\"Rs.\",\"offers\":[],\"thumb\":\"https://b.zmtcdn.com/data/pictures/chains/9/57329/edfe26cdf889362bf360ea776982f68c_featured_v2.jpg\",\"user_rating\":{\"aggregate_rating\":\"3.9\",\"rating_text\":\"Very Good\",\"rating_color\":\"5BA829\",\"votes\":\"1710\"},\"photos_url\":\"https://www.zomato.com/bangalore/smallys-resto-cafe-church-street/photos#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"menu_url\":\"https://www.zomato.com/bangalore/smallys-resto-cafe-church-street/menu#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"featured_image\":\"https://b.zmtcdn.com/data/pictures/chains/9/57329/edfe26cdf889362bf360ea776982f68c_featured_v2.jpg\",\"has_online_delivery\":1,\"is_delivering_now\":1,\"deeplink\":\"zomato://r/60587\",\"order_url\":\"https://www.zomato.com/bangalore/smallys-resto-cafe-church-street/order?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"order_deeplink\":\"\",\"events_url\":\"https://www.zomato.com/bangalore/smallys-resto-cafe-church-street/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\"}}}}";
        GeoCode geoCode = objectMapper.readValue(geoCodeString, GeoCode.class);
        assertEquals(geoCode.getLocation().getCityId(), 4);
        assertEquals(geoCode.getPopularity().getNightlifeIndex(), 5.00);
    }

    @Test
    public void testCreateLocalityFromString() throws Exception {
        String localityString = "{\n" +
                "    \"entity_type\": \"group\",\n" +
                "    \"entity_id\": \"36932\",\n" +
                "    \"title\": \"Chelsea Market, Chelsea, New York City\",\n" +
                "    \"latitude\": \"40.742051\",\n" +
                "    \"longitude\": \"-74.004821\",\n" +
                "    \"city_id\": \"280\",\n" +
                "    \"city_name\": \"New York City\",\n" +
                "    \"country_id\": \"216\",\n" +
                "    \"country_name\": \"United States\"\n" +
                "  }";
        Locality locality = objectMapper.readValue(localityString, Locality.class);
        assertEquals(locality.getCityId(), 280);
        assertEquals(locality.getLatitude(), 40.742051);
    }

    @Test
    public void testCreateLocationFromString() throws Exception {
        String locationString = "{\n" +
                "        \"address\": \"1 5th Avenue, New York, NY 10003\",\n" +
                "        \"locality\": \"Greenwich Village\",\n" +
                "        \"city\": \"New York City\",\n" +
                "        \"latitude\": \"40.732013\",\n" +
                "        \"longitude\": \"-73.996155\",\n" +
                "        \"zipcode\": \"10003\",\n" +
                "        \"country_id\": \"216\"\n" +
                "      }";
        Location location = objectMapper.readValue(locationString, Location.class);
        assertEquals(location.getCity(), "New York City");
        assertEquals(location.getLatitude(), 40.732013);
    }

    @Test
    public void testCreatePhotoFromString() throws Exception {
        String photoString = "{\n" +
                "          \"id\": \"u_MjA5MjY1OTk5OT\",\n" +
                "          \"url\": \"https://b.zmtcdn.com/data/reviews_photos/c15/9eb13ceaf6e90129c276ce6ff980bc15_1435111695_640_640_thumb.JPG\",\n" +
                "          \"thumb_url\": \"https://b.zmtcdn.com/data/reviews_photos/c15/9eb13ceaf6e90129c276ce6ff980bc15_1435111695_200_thumb.JPG\",\n" +
                "          \"user\": {\n" +
                "            \"name\": \"John Doe\",\n" +
                "            \"zomato_handle\": \"John\",\n" +
                "            \"foodie_level\": \"Super Foodie\",\n" +
                "            \"foodie_level_num\": \"9\",\n" +
                "            \"foodie_color\": \"f58552\",\n" +
                "            \"profile_url\": \"https://www.zomato.com/john\",\n" +
                "            \"profile_deeplink\": \"zoma.to/u/1170245\",\n" +
                "            \"profile_image\": \"string\"\n" +
                "          },\n" +
                "          \"res_id\": \"16782899\",\n" +
                "          \"caption\": \"#awesome\",\n" +
                "          \"timestamp\": \"1435111770\",\n" +
                "          \"friendly_time\": \"3 months ago\",\n" +
                "          \"width\": \"640\",\n" +
                "          \"height\": \"640\",\n" +
                "          \"comments_count\": \"0\",\n" +
                "          \"likes_count\": \"0\"\n" +
                "        }";
        Photo photo = objectMapper.readValue(photoString, Photo.class);
        assertEquals(photo.getId(), "u_MjA5MjY1OTk5OT");
        assertEquals(photo.getUser().getName(), "John Doe");
    }

    @Test
    public void testCreatePopularityFromString() throws Exception {
        String popularityString = "{\n" +
                "    \"popularity\": \"4.92\",\n" +
                "    \"nightlife_index\": \"4.95\",\n" +
                "    \"top_cuisines\": [\n" +
                "      \"cafe\"\n" +
                "    ]\n" +
                "  }";
        Popularity popularity = objectMapper.readValue(popularityString, Popularity.class);
        assertEquals(popularity.getPopularity(), 4.92);
    }

    @Test
    public void testCreateRestaurantFromString() throws Exception {
        String restaurantString = "{\n" +
                "  \"id\": \"16774318\",\n" +
                "  \"name\": \"Otto Enoteca & Pizzeria\",\n" +
                "  \"url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village\",\n" +
                "  \"location\": {\n" +
                "    \"address\": \"1 5th Avenue, New York, NY 10003\",\n" +
                "    \"locality\": \"Greenwich Village\",\n" +
                "    \"city\": \"New York City\",\n" +
                "    \"latitude\": \"40.732013\",\n" +
                "    \"longitude\": \"-73.996155\",\n" +
                "    \"zipcode\": \"10003\",\n" +
                "    \"country_id\": \"216\"\n" +
                "  },\n" +
                "  \"average_cost_for_two\": \"60\",\n" +
                "  \"price_range\": \"2\",\n" +
                "  \"currency\": \"$\",\n" +
                "  \"thumb\": \"https://b.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077_featured_thumb.png\",\n" +
                "  \"featured_image\": \"https://d.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077_featured_v2.png\",\n" +
                "  \"photos_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/photos#tabtop\",\n" +
                "  \"menu_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/menu#tabtop\",\n" +
                "  \"events_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/events#tabtop\",\n" +
                "  \"user_rating\": {\n" +
                "    \"aggregate_rating\": \"3.7\",\n" +
                "    \"rating_text\": \"Very Good\",\n" +
                "    \"rating_color\": \"5BA829\",\n" +
                "    \"votes\": \"1046\"\n" +
                "  },\n" +
                "  \"has_online_delivery\": \"0\",\n" +
                "  \"is_delivering_now\": \"0\",\n" +
                "  \"deeplink\": \"zomato://r/16774318\",\n" +
                "  \"cuisines\": \"Cafe\",\n" +
                "  \"all_reviews_count\": \"15\",\n" +
                "  \"photo_count\": \"18\",\n" +
                "  \"phone_numbers\": \"(212) 228-2930\",\n" +
                "  \"photos\": [\n" +
                "    {\n" +
                "      \"id\": \"u_MjA5MjY1OTk5OT\",\n" +
                "      \"url\": \"https://b.zmtcdn.com/data/reviews_photos/c15/9eb13ceaf6e90129c276ce6ff980bc15_1435111695_640_640_thumb.JPG\",\n" +
                "      \"thumb_url\": \"https://b.zmtcdn.com/data/reviews_photos/c15/9eb13ceaf6e90129c276ce6ff980bc15_1435111695_200_thumb.JPG\",\n" +
                "      \"user\": {\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"zomato_handle\": \"John\",\n" +
                "        \"foodie_level\": \"Super Foodie\",\n" +
                "        \"foodie_level_num\": \"9\",\n" +
                "        \"foodie_color\": \"f58552\",\n" +
                "        \"profile_url\": \"https://www.zomato.com/john\",\n" +
                "        \"profile_deeplink\": \"zoma.to/u/1170245\",\n" +
                "        \"profile_image\": \"string\"\n" +
                "      },\n" +
                "      \"res_id\": \"16782899\",\n" +
                "      \"caption\": \"#awesome\",\n" +
                "      \"timestamp\": \"1435111770\",\n" +
                "      \"friendly_time\": \"3 months ago\",\n" +
                "      \"width\": \"640\",\n" +
                "      \"height\": \"640\",\n" +
                "      \"comments_count\": \"0\",\n" +
                "      \"likes_count\": \"0\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"all_reviews\": [\n" +
                "    {\n" +
                "      \"rating\": \"5\",\n" +
                "      \"review_text\": \"The best latte I've ever had. It tasted a little sweet\",\n" +
                "      \"id\": \"24127336\",\n" +
                "      \"rating_color\": \"305D02\",\n" +
                "      \"review_time_friendly\": \"2 months ago\",\n" +
                "      \"rating_text\": \"Insane!\",\n" +
                "      \"timestamp\": \"1435507367\",\n" +
                "      \"likes\": \"0\",\n" +
                "      \"user\": {\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"zomato_handle\": \"John\",\n" +
                "        \"foodie_level\": \"Super Foodie\",\n" +
                "        \"foodie_level_num\": \"9\",\n" +
                "        \"foodie_color\": \"f58552\",\n" +
                "        \"profile_url\": \"https://www.zomato.com/john\",\n" +
                "        \"profile_deeplink\": \"zoma.to/u/1170245\",\n" +
                "        \"profile_image\": \"string\"\n" +
                "      },\n" +
                "      \"comments_count\": \"0\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Restaurant restaurant = objectMapper.readValue(restaurantString, Restaurant.class);
        assertEquals(restaurant.getId(), 16774318);
    }

    @Test
    public void testCreateReviewFromString() throws Exception {
        String reviewString = " {\n" +
                "          \"rating\": \"5\",\n" +
                "          \"review_text\": \"The best latte I've ever had. It tasted a little sweet\",\n" +
                "          \"id\": \"24127336\",\n" +
                "          \"rating_color\": \"305D02\",\n" +
                "          \"review_time_friendly\": \"2 months ago\",\n" +
                "          \"rating_text\": \"Insane!\",\n" +
                "          \"timestamp\": \"1435507367\",\n" +
                "          \"likes\": \"0\",\n" +
                "          \"user\": {\n" +
                "            \"name\": \"John Doe\",\n" +
                "            \"zomato_handle\": \"John\",\n" +
                "            \"foodie_level\": \"Super Foodie\",\n" +
                "            \"foodie_level_num\": \"9\",\n" +
                "            \"foodie_color\": \"f58552\",\n" +
                "            \"profile_url\": \"https://www.zomato.com/john\",\n" +
                "            \"profile_deeplink\": \"zoma.to/u/1170245\",\n" +
                "            \"profile_image\": \"string\"\n" +
                "          },\n" +
                "          \"comments_count\": \"0\"\n" +
                "        }";
        Review review = objectMapper.readValue(reviewString, Review.class);
        assertEquals(review.getId(), 24127336);
        assertEquals(review.getUser().getName(), "John Doe");

    }

    @Test
    public void testCreateUserFromString() throws Exception {
        String userString = "{\n" +
                "            \"name\": \"John Doe\",\n" +
                "            \"zomato_handle\": \"John\",\n" +
                "            \"foodie_level\": \"Super Foodie\",\n" +
                "            \"foodie_level_num\": \"9\",\n" +
                "            \"foodie_color\": \"f58552\",\n" +
                "            \"profile_url\": \"https://www.zomato.com/john\",\n" +
                "            \"profile_deeplink\": \"zoma.to/u/1170245\",\n" +
                "            \"profile_image\": \"string\"\n" +
                "          }";
        User user = objectMapper.readValue(userString, User.class);
        assertEquals(user.getName(), "John Doe");
        assertEquals(user.getZomatoHandle(), "John");
    }

    @Test
    public void testCreateUserRatingFromString() throws Exception {
        String userRatingString = "{\n" +
                "        \"aggregate_rating\": \"3.7\",\n" +
                "        \"rating_text\": \"Very Good\",\n" +
                "        \"rating_color\": \"5BA829\",\n" +
                "        \"votes\": \"1046\"\n" +
                "      }";
        UserRating userRating = objectMapper.readValue(userRatingString, UserRating.class);
        assertEquals(userRating.getRatingText(), "Very Good");
        assertEquals(userRating.getAggregateRating(), 3.7);
    }
}


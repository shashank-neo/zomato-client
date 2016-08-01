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
        String geoCodeString = "{\"location\":{\"entity_type\":\"group\",\"entity_id\":\"36932\",\"title\":\"Chelsea " +
                "Market, Chelsea, New York City\",\"latitude\":\"40.742051\",\"longitude\":\"-74.004821\",\"city_id\":\"280\"," +
                "\"city_name\":\"New York City\",\"country_id\":\"216\",\"country_name\":\"United States\"},\"popularity\":" +
                "{\"popularity\":\"4.92\",\"nightlife_index\":\"4.95\",\"top_cuisines\":[\"cafe\"]}," +
                "\"link\":\"https://www.zomato.com/new-york-city/chelsea-restaurants\",\"nearby_restaurants\":" +
                "[{\"id\":\"16774318\",\"name\":\"Otto Enoteca & Pizzeria\"," +
                "\"url\":\"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village\"," +
                "\"location\":{\"address\":\"1 5th Avenue, New York, NY 10003\",\"locality\":\"Greenwich Village\"," +
                "\"city\":\"New York City\",\"latitude\":\"40.732013\",\"longitude\":\"-73.996155\",\"zipcode\":\"10003\"," +
                "\"country_id\":\"216\"},\"average_cost_for_two\":\"60\",\"price_range\":\"2\",\"currency\":\"$\"," +
                "\"thumb\":\"https://b.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077" +
                "_featured_thumb.png\",\"featured_image\":\"https://d.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4d" +
                "bb79dd7c8091b30c642077_featured_v2.png\",\"photos_url\":\"https://www.zomato.com/new-york-city/" +
                "otto-enoteca-pizzeria-greenwich-village/photos#tabtop\",\"menu_url\":\"https://www.zomato.com/new-york-city/" +
                "otto-enoteca-pizzeria-greenwich-village/menu#tabtop\",\"events_url\":\"https://www.zomato.com/" +
                "new-york-city/otto-enoteca-pizzeria-greenwich-village/events#tabtop\",\"user_rating\":{\"aggregate_rating\":" +
                "\"3.7\",\"rating_text\":\"Very Good\",\"rating_color\":\"5BA829\",\"votes\":\"1046\"},\"has_online_delivery" +
                "\":\"0\",\"is_delivering_now\":\"0\",\"deeplink\":\"zomato://r/16774318\",\"cuisines\":\"Cafe\"," +
                "\"all_reviews_count\":\"15\",\"photo_count\":\"18\",\"phone_numbers\":\"(212) 228-2930\",\"photos\":" +
                "[{\"id\":\"u_MjA5MjY1OTk5OT\",\"url\":\"https://b.zmtcdn.com/data/reviews_photos/c15/9eb13ceaf6e90129c27" +
                "6ce6ff980bc15_1435111695_640_640_thumb.JPG\",\"thumb_url\":\"https://b.zmtcdn.com/data/reviews_photos/c15/" +
                "9eb13ceaf6e90129c276ce6ff980bc15_1435111695_200_thumb.JPG\",\"user\":{\"name\":\"John Doe\",\"zomato_handle" +
                "\":\"John\",\"foodie_level\":\"Super Foodie\",\"foodie_level_num\":\"9\",\"foodie_color\":\"f58552\"," +
                "\"profile_url\":\"https://www.zomato.com/john\",\"profile_deeplink\":\"zoma.to/u/1170245\",\"profile_image\"" +
                ":\"string\"},\"res_id\":\"16782899\",\"caption\":\"#awesome\",\"timestamp\":\"1435111770\",\"friendly_time\"" +
                ":\"3 months ago\",\"width\":\"640\",\"height\":\"640\",\"comments_count\":\"0\",\"likes_count\":\"0\"}]," +
                "\"all_reviews\":[{\"rating\":\"5\",\"review_text\":\"The best latte I've ever had. It tasted a little " +
                "sweet\",\"id\":\"24127336\",\"rating_color\":\"305D02\",\"review_time_friendly\":\"2 months ago\"" +
                ",\"rating_text\":\"Insane!\",\"timestamp\":\"1435507367\",\"likes\":\"0\",\"user\":{\"name\":\"John Doe\"," +
                "\"zomato_handle\":\"John\",\"foodie_level\":\"Super Foodie\",\"foodie_level_num\":\"9\",\"foodie_color\":" +
                "\"f58552\",\"profile_url\":\"https://www.zomato.com/john\",\"profile_deeplink\":\"zoma.to/u/1170245\"," +
                "\"profile_image\":\"string\"},\"comments_count\":\"0\"}]}]}";
        GeoCode geoCode = objectMapper.readValue(geoCodeString, GeoCode.class);
        assertEquals(geoCode.getLocation().getCityId(), 280);
        assertEquals(geoCode.getPopularity().getNightlifeIndex(), 4.95);
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


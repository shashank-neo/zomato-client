package com.falcon.zomatoclient.domain.restaurant;

import com.falcon.zomatoclient.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  26/07/16. <br/> Updated on 26/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public class RestaurantDeserializationTest {
    private final ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();

    @Test
    public void testCreateDailyMenuFromString() throws Exception {
        String dailyMenuString = "{\n" +
                "      \"daily_menu_id\": \"16507624\",\n" +
                "      \"name\": \"Vinohradský pivovar\",\n" +
                "      \"start_date\": \"2016-03-08 11:00\",\n" +
                "      \"end_date\": \"2016-03-08 15:00\",\n" +
                "      \"dishes\": [\n" +
                "        {\n" +
                "          \"dish_id\": \"104089345\",\n" +
                "          \"name\": \"Tatarák ze sumce s toustem\",\n" +
                "          \"price\": \"149 Kč\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }";
        DailyMenu dailyMenu = objectMapper.readValue(dailyMenuString, DailyMenu.class);
        assertEquals(dailyMenu.getDailyMenuId(), 16507624);
        assertEquals(dailyMenu.getStartDate(), new Date(1457415000000L));
    }

    @Test
    public void testCreateDishFromString() throws Exception {
        String dishString = "{\n" +
                "          \"dish_id\": \"104089345\",\n" +
                "          \"name\": \"Tatarák ze sumce s toustem\",\n" +
                "          \"price\": \"149 Kč\"\n" +
                "        }";
        Dish dish = objectMapper.readValue(dishString, Dish.class);
        assertEquals(dish.getDishId(), 104089345);
    }

    @Test
    public void testCreateSearchResultFromString() throws Exception {
        String searchString = "{\n" +
                "  \"results_found\": \"53\",\n" +
                "  \"results_start\": \"11\",\n" +
                "  \"results_shown\": \"10\",\n" +
                "  \"restaurants\": [\n" +
                "    {\n" +
                "      \"id\": \"16774318\",\n" +
                "      \"name\": \"Otto Enoteca & Pizzeria\",\n" +
                "      \"url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village\",\n" +
                "      \"location\": {\n" +
                "        \"address\": \"1 5th Avenue, New York, NY 10003\",\n" +
                "        \"locality\": \"Greenwich Village\",\n" +
                "        \"city\": \"New York City\",\n" +
                "        \"latitude\": \"40.732013\",\n" +
                "        \"longitude\": \"-73.996155\",\n" +
                "        \"zipcode\": \"10003\",\n" +
                "        \"country_id\": \"216\"\n" +
                "      },\n" +
                "      \"average_cost_for_two\": \"60\",\n" +
                "      \"price_range\": \"2\",\n" +
                "      \"currency\": \"$\",\n" +
                "      \"thumb\": \"https://b.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077_featured_thumb.png\",\n" +
                "      \"featured_image\": \"https://d.zmtcdn.com/data/pictures/chains/8/16774318/a54deb9e4dbb79dd7c8091b30c642077_featured_v2.png\",\n" +
                "      \"photos_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/photos#tabtop\",\n" +
                "      \"menu_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/menu#tabtop\",\n" +
                "      \"events_url\": \"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/events#tabtop\",\n" +
                "      \"user_rating\": {\n" +
                "        \"aggregate_rating\": \"3.7\",\n" +
                "        \"rating_text\": \"Very Good\",\n" +
                "        \"rating_color\": \"5BA829\",\n" +
                "        \"votes\": \"1046\"\n" +
                "      },\n" +
                "      \"has_online_delivery\": \"0\",\n" +
                "      \"is_delivering_now\": \"0\",\n" +
                "      \"deeplink\": \"zomato://r/16774318\",\n" +
                "      \"cuisines\": \"Cafe\",\n" +
                "      \"all_reviews_count\": \"15\",\n" +
                "      \"photo_count\": \"18\",\n" +
                "      \"phone_numbers\": \"(212) 228-2930\",\n" +
                "      \"photos\": [\n" +
                "        {\n" +
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
                "        }\n" +
                "      ],\n" +
                "      \"all_reviews\": [\n" +
                "        {\n" +
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
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        SearchRestaurantResult searchRestaurantResult = objectMapper.readValue(searchString, SearchRestaurantResult.class);
        assertEquals(searchRestaurantResult.getResultsFound(), 53);
    }
}

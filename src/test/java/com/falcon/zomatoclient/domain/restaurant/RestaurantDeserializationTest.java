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
        String searchString = "{\"results_found\":8559,\"results_start\":0,\"results_shown\":20,\"restaurants\":[{\"restaurant\":{\"R\":{\"res_id\":18237913},\"apikey\":\"f8127748b93648c2b92d64c70be35d0c\",\"id\":\"18237913\",\"name\":\"By/Two - Olde Bangalore\",\"url\":\"https://www.zomato.com/bangalore/by-two-olde-bangalore-international-airport?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"location\":{\"address\":\"Olde Bangalore Resort and Convention Center, Near International Airport, Tarabanahalli, Chikkajala Post, International Airport, Bangalore\",\"locality\":\"International Airport\",\"city\":\"Bangalore\",\"city_id\":4,\"latitude\":\"13.1914420000\",\"longitude\":\"77.6226250000\",\"zipcode\":\"\",\"country_id\":1},\"cuisines\":\"Desserts, Fast Food\",\"average_cost_for_two\":750,\"price_range\":2,\"currency\":\"Rs.\",\"offers\":[],\"thumb\":\"https://b.zmtcdn.com/data/pictures/chains/3/18237913/5256670531226e3100bd825413c43782_featured_v2.jpg\",\"user_rating\":{\"aggregate_rating\":\"0\",\"rating_text\":\"Not rated\",\"rating_color\":\"CBCBC8\",\"votes\":\"0\"},\"photos_url\":\"https://www.zomato.com/bangalore/by-two-olde-bangalore-international-airport/photos#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"menu_url\":\"https://www.zomato.com/bangalore/by-two-olde-bangalore-international-airport/menu#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"featured_image\":\"https://b.zmtcdn.com/data/pictures/chains/3/18237913/5256670531226e3100bd825413c43782_featured_v2.jpg\",\"has_online_delivery\":0,\"is_delivering_now\":0,\"deeplink\":\"zomato://r/18237913\",\"events_url\":\"https://www.zomato.com/bangalore/by-two-olde-bangalore-international-airport/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"establishment_types\":[]}}]}";
        SearchRestaurantResult searchRestaurantResult = objectMapper.readValue(searchString, SearchRestaurantResult.class);
        assertEquals(searchRestaurantResult.getResultsFound(), 8559);
    }
}

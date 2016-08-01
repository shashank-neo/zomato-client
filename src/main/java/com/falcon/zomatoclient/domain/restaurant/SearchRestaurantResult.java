package com.falcon.zomatoclient.domain.restaurant;

import com.falcon.zomatoclient.domain.common.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  26/07/16. <br/> Updated on 26/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRestaurantResult {
    private int resultsFound;
    private int resultsStart;
    private int resultsShown;
    private List<Map<String, Restaurant>> restaurants;
}

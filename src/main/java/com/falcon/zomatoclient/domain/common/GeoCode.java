package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCode {
    private Locality location;
    private Popularity popularity;
    private String link;
    private Map<String,Map<String, Restaurant>> nearbyRestaurants;

}

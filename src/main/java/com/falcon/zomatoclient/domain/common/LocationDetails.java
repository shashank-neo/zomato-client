package com.falcon.zomatoclient.domain.common;

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
public class LocationDetails {
    private double popularity;
    private double nightlifeIndex;
    private List<Long> nearbyRes;
    private Locality location;
    private List<Map<String,Restaurant>> bestRatedRestaurant;
    private List<String> topCuisines;
    private int popularityRes;
    private int nightlifeRes;
    private String subzone;
    private int subzoneId;
    private String city;
    private int numRestaurant;
}

package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  06/07/16. <br/> Updated on 06/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Popularity {
    private double popularity;
    private double nightlifeIndex;
    private List<String> topCuisines;
    private List<String> nearbyRes;
}

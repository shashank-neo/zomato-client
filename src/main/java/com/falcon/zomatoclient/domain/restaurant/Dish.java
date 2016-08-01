package com.falcon.zomatoclient.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  26/07/16. <br/> Updated on 26/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dish {
    private long dishId;
    private String name;
    private String price;
}

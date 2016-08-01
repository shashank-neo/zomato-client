package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String address;
    private String locality;
    private String city;
    private double latitude;
    private double longitude;
    private int zipcode;
    private long counryId;
}

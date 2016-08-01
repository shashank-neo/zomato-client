package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  06/07/16. <br/> Updated on 06/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locality {
    private String entityType;
    private long entityId;
    private String title;
    private double latitude;
    private double longitude;
    private long cityId;
    private String cityName;
    private long countryId;
    private String countryName;
}

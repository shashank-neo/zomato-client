package com.falcon.zomatoclient.domain.result;

import com.falcon.zomatoclient.domain.common.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CitiesResult {
    private String status;
    private int hasMore;
    private int hasTotal;
    private List<City> locationSuggestions;
}

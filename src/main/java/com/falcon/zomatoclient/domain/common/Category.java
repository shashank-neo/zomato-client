package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  06/07/16. <br/> Updated on 06/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Category {
    private long id;
    private String name;
}

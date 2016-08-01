package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String zomatoHandle;
    private String foodieLevel;
    private int foodieLevelNum;
    private String foodieColor;
    private String profileUrl;
    private String profileDeeplink;
    private String profileImage;
}

package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    private String id;
    private String url;
    private String thumbUrl;
    private User user;
    private String resId;
    private String caption;
    private long timestamp;
    private String friendlyTime;
    private int width;
    private int height;
    private long commentsCount;
    private long likesCount;
}

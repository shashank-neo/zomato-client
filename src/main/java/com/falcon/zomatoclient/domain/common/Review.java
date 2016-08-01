package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    private int rating;
    private String reviewText;
    private long id;
    private String ratingColor;
    private String reviewTimeFriendly;
    private String ratingText;
    private long timestamp;
    private long likes;
    private User user;
    private long commentsCount;
}

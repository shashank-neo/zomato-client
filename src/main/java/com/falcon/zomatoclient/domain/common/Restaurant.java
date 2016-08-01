package com.falcon.zomatoclient.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  08/07/16. <br/> Updated on 08/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    private long id;
    private String name;
    private String url;
    private Location location;
    private int averageCostForTwo;
    private int priceRange;
    private String currency;
    private String thumb;
    private String featuredImage;
    private String photosUrl;
    private String menuUrl;
    private String eventsUrl;
    private UserRating userRating;
    private String hasOnlineDelivery;
    private boolean isDeliveringNow;
    private String deeplink;
    private String cuisines;
    private long allReviewsCount;
    private long photoCount;
    private String phoneNumbers;
    private List<Photo> photos;
    private List<Review> allReviews;

}

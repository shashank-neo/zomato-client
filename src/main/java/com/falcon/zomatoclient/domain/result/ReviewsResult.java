package com.falcon.zomatoclient.domain.result;

import com.falcon.zomatoclient.domain.common.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewsResult {
    private int reviewsCount;
    private int reviewsStart;
    private int reviewsShown;
    private List<Map<String, Review>> userReviews;

}

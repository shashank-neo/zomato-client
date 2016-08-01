package com.falcon.zomatoclient.domain.restaurant;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public enum SortOption {
    COST("cost"), RATING("rating"), REALDISTANCE("real_distance");

    private final String value;

    SortOption(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

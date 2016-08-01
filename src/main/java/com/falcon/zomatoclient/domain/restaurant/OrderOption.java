package com.falcon.zomatoclient.domain.restaurant;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public enum OrderOption {
    ASC("asc"), DESC("desc");

    private final String value;

    OrderOption(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

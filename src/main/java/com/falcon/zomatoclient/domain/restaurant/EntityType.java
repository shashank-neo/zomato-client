package com.falcon.zomatoclient.domain.restaurant;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public enum EntityType {
    CITY("city"), SUBZONE("subzone"), ZONE("zone"), LANDMARK("landmark"), METRO("metro"), GROUP("group");

    private final String value;

    EntityType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

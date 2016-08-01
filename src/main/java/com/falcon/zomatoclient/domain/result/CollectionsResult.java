package com.falcon.zomatoclient.domain.result;

import com.falcon.zomatoclient.domain.common.Collection;
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
public class CollectionsResult {
    private int hasMore;
    private int hasTotal;
    private String shareUrl;
    private String displayText;
    private  List<Map<String, Collection>> collections;
}

package com.falcon.zomatoclient.domain.result;

import com.falcon.zomatoclient.domain.common.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  01/08/16. <br/> Updated on 01/08/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories {
    private Category categories;
}

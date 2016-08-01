package com.falcon.zomatoclient.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.Data;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  31/07/16. <br/> Updated on 31/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyMenus {
    private List<DailyMenu> dailyMenu;
}

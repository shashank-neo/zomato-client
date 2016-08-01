package com.falcon.zomatoclient.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by shwet.s under project zomato-client. <br/> Created on  26/07/16. <br/> Updated on 26/07/16.  <br/> Updated
 * by shwet.s. <br/>
 */
public class ObjectMapperUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm"); //2016-03-08 11:00
        objectMapper.setDateFormat(dateFormat);
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}

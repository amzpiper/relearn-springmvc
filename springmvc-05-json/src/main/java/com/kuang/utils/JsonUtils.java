package com.kuang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author 郭宇航
 * @date 2021/10/2
 * @apiNote
 */
public class JsonUtils {

    /**
     * 转object为json字符串，和配置时间返回格式
     * @param object 转json字符串的对象
     * @return json字符串
     */
    public static String getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转object为json字符串，和配置时间返回格式
     * @param object 转json字符串的对象
     * @param sdf 时间返回格式字符串
     * @return json字符串
     */
    public static String getJson(Object object,String sdf) {
        ObjectMapper mapper = new ObjectMapper();

        //关闭使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf);
        //设置为自定义格式
        mapper.setDateFormat(simpleDateFormat);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

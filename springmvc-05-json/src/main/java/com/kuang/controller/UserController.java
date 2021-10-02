package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/10/2
 * @apiNote
 */
//@Controller
@RestController //所有的方法都不在视图解析器,直接返回数据
public class UserController {

    /**
     * 普通对象
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j1")
    //@ResponseBody //不走视图解析器,直接返回字符串
    public String json1() throws JsonProcessingException {
        User user = new User("亲家境",12,"男");
        //jackson,ObjectMapper
        //ObjectMapper把对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        return json;
    }

    /**
     * 集合对象
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j2")
    public String json2() throws JsonProcessingException {
        List<User> users = new ArrayList<>();
        User user = new User("亲家境", 12, "男");
        User user2 = new User("亲家境", 12, "男");
        User user3 = new User("亲家境", 12, "男");
        User user4 = new User("亲家境", 12, "男");
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //ObjectMapper把对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(users);

        return json;
    }

    /**
     * 时间对象
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {
        //ObjectMapper把对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //将时间解析后的默认格式为Timestamp 1633167988542
        String json = mapper.writeValueAsString(date);

        //第一种格式化时间:手动
        //自定义返回格式 yyy-MM-dd HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        json = mapper.writeValueAsString(simpleDateFormat.format(date));

        //第二种：使用mapper.configure配置
        //关闭使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        //设置为自定义格式
        mapper.setDateFormat(sdf);

        json = mapper.writeValueAsString(simpleDateFormat.format(date));
        return json;
    }

    /**
     * 测试使用jsonUtils
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j4")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date, "yyy-MM-dd HH:mm:ss");
    }

    /**
     * 测试使用fastjson
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j5")
    public String json5() throws JsonProcessingException {
        String json;

        //java的list对象转json数组字符串
        List<User> users = new ArrayList<>();
        User user = new User("亲家境", 12, "男");
        User user2 = new User("亲家境", 12, "男");
        User user3 = new User("亲家境", 12, "男");
        User user4 = new User("亲家境", 12, "男");
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        json = JSON.toJSONString(users);
        System.out.println("java的list对象转json数组字符串:");
        System.out.println(json);

        //json数组字符串转java的list对象
        List<User> jsonArray = JSON.parseArray(json,User.class);
        System.out.println("json数组字符串转java的list对象:");
        for (User user1 : jsonArray) {
            System.out.println(user1.toString());
        }

        //java对象转json字符串
        json = JSON.toJSONString(user);
        System.out.println("java对象转json字符串:");
        System.out.println(json);

        //json对象字符串转java对象
        user = JSON.parseObject(json, User.class);
        System.out.println("json对象字符串转java对象:");
        System.out.println(json);

        return json;
    }

}

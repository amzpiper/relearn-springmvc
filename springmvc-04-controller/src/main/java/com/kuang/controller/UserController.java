package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 郭宇航
 * @date 2021/10/2
 * @apiNote
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/test1")
    public String test1(String name, Model model) {
        //1.接收前端参数
        System.out.println(name);
        //2.将返回结果传递给前端
        model.addAttribute("msg", name);
        //3.跳转试图
        return "test";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("username")String name, Model model) {
        //1.接收前端参数
        System.out.println(name);
        //2.将返回结果传递给前端
        model.addAttribute("msg", name);
        //3.跳转试图
        return "test";
    }

    /**
     * 前端传递对象：id，name，age
     * 接收参数时，判断参数的名字，假设名字直接在方法参数里，直接使用
     * 假设传递的是一个对象User，匹配User对象中的字段名。匹配不到为null
     */
    @GetMapping("/test3")
    public String test3(User user, Model model) {
        //1.接收前端参数
        System.out.println(user.toString());
        //2.将返回结果传递给前端
        model.addAttribute("msg", user.toString());
        //3.跳转试图
        return "test";
    }

    @GetMapping("/test4")
    public String test4(User user,ModelMap map) {
        //1.接收前端参数
        System.out.println(user.toString());
        //2.将返回结果传递给前端
        map.addAttribute("msg", user.toString());
        //3.跳转试图
        return "test";
    }

}

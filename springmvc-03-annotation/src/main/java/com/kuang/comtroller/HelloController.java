package com.kuang.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭宇航
 * @date 2021/10/1
 * @apiNote
 */
@Controller
//@RestController 不调用视图解析器，直接返回数据，json格式用他
@RequestMapping("/hello")
public class HelloController {


    /**
     * 访问地址 http://localhost/hello/h1
     * 封装数据到 model
     * @param model
     */
    @RequestMapping(value ="/h1")
    public String hello(Model model) {
        //向模型中添加属性msg和值，可以在jsp中取出来并渲染
        model.addAttribute("msg", "Hello,SpringMVCAnnotation!");

        //会被视图解析器处理,hello是视图名字
        return "hello";
    }
}

package com.kuang.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郭宇航
 * @date 2021/10/1
 * @apiNote
 */
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView vm = new ModelAndView();

        //业务逻辑
        String result = "Hello SpringMVC!";

        vm.addObject("msg", result);
        vm.setViewName("hello");
        return vm;
    }
}

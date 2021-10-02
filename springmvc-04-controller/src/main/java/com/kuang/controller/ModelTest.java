package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class ModelTest {

    //Servlet实现
    @GetMapping("/m1")
    public void m1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello,SpringMVC");
    }

    @GetMapping("/m2")
    public void m2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //重定向
        response.sendRedirect("/index.jsp");
    }

    @GetMapping("/m3")
    public void m3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //转发
        request.setAttribute("msg","request.getRequestDispatcher");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }

    //Springmvc-无视图解析器
    @GetMapping("/mvcm1")
    public String mvcm1(){
        //转发
        return "/index.jsp";
    }

    @GetMapping("/mvcm2")
    public String mvcm2() {
        //转发
        return "forward:/index.jsp";
    }

    @GetMapping("/mvcm3")
    public String mvcm3() {
        //重定向
        return "redirect:/index.jsp";
    }

    //Springmvc-配置视图解析器
    @GetMapping("/mvcm4")
    public String mvcm4(){
        //转发
        return "test";
    }

    @GetMapping("/mvcm5")
    public String mvcm5() {
        //重定向
        return "redirect:/index.jsp";
    }

}

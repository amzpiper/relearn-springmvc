package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郭宇航
 * @date 2021/10/1
 * @apiNote
 */
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest2");
        return "test";
    }
}

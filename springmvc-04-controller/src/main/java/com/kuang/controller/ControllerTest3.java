package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 郭宇航
 * @date 2021/10/1
 * @apiNote
 */
@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest3");
        return "test";
    }
}

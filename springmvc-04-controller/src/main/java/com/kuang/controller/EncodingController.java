package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 郭宇航
 * @date 2021/10/2
 * @apiNote
 */
@Controller
public class EncodingController {

    @PostMapping("/e1/t1")
    public String test1(String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }

}
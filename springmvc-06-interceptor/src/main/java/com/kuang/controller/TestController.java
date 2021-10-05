package com.kuang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭宇航
 * @date 2021/10/5
 * @apiNote
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "ok";
    }
}

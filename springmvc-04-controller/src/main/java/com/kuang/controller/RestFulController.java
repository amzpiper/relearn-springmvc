package com.kuang.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郭宇航
 * @date 2021/10/1
 * @apiNote
 */
@Controller
public class RestFulController {

    //@RequestMapping(value="/add/{a}/{b}",method  = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "和为：" + res);
        return "test";
    }

    //@RequestMapping(value="/add/{a}/{b}",method  = RequestMethod.GET)
    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a * b;
        model.addAttribute("msg", "乘积为：" + res);
        return "test";
    }

}

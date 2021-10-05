package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 郭宇航
 * @date 2021/10/5
 * @apiNote
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password) {
        session.setAttribute("userLoginInfo",username);
        //登录成功
        return "main";
    }

    @GetMapping("/signOut")
    public String signOut(HttpSession session) {
        session.removeAttribute("userLoginInfo");
        return "login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/goLogin")
    public String goLogin() {
        return "login";
    }
}

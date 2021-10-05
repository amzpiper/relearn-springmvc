package com.kuang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郭宇航
 * @date 2021/10/5
 * @apiNote
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 前置:判断什么情况下没有登录
     * 用户没有登录应该重定向，而不是false
     * 判断session
     * 返回true就是放行，执行下一个拦截器
     * 返回false就是拦截，不执行下一个拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====处理是否登录=======");
        //已登录时放行
        if (request.getSession().getAttribute("userLoginInfo") != null) {
            return true;
        }
        //前往登录界面时放行
        if (request.getRequestURI().contains("ogin")){
            return true;
        }
        //否则重定向到登录
        response.sendRedirect("/goLogin");
        return false;
    }
}

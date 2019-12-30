package com.hupeng.controller.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if(!accountByCookie(cookies) && !accountBySession(session)) {
            response.sendRedirect("login.jsp");
        }
        return true;
    }
    private boolean accountBySession(HttpSession session) {
        return session.getAttribute("account")==null?false:true;
    }
    private boolean accountByCookie(Cookie[] cookies) {
        if(cookies != null){
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("account") && cookie.getValue() != null) {
                    return true;
                }
            }
        }
        return false;
    }
}

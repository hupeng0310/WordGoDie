package com.hupeng.controller.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExaminationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("allowExamination") == null || !(boolean) (session.getAttribute("allowExamination"))){
            response.sendError(403,"forbidden get examination");
        }else {
            System.out.println("allowExamination");
        }
        return true;
    }
}

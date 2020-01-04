package com.hupeng.controller.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExaminationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getAttribute("allowExamination") == null || !((boolean) (request.getAttribute("allowExamination")))){
            response.sendError(500,"forbiddenExamination");
        }
        return true;
    }
}

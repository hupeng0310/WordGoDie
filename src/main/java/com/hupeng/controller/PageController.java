package com.hupeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @RequestMapping("/page")
    public String getPage(String target, HttpServletRequest request){
        //当请求*examination.jsp页面时,为拉取试题信息放行
        if(target.indexOf("examination.jsp") != -1) {
            request.setAttribute("allowExamination",true);
        }else {
            request.setAttribute("allowExamination",false);
        }
        return target;
    }
}

package com.hupeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @RequestMapping("/page")
    public String getPage(String target, HttpServletRequest request){
        HttpSession session = request.getSession();
        //当请求*examination.jsp页面时,为拉取试题信息放行
        if(target.indexOf("examination") != -1) {
            session.setAttribute("allowExamination",true);
        }else {
            session.setAttribute("allowExamination",false);
        }
        return target;
    }
}

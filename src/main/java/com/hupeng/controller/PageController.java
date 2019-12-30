package com.hupeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/page")
    public String getPage(String target){
        return target;
    }
}

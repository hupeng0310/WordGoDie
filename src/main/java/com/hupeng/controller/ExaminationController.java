package com.hupeng.controller;
import com.hupeng.service.TopicService;
import com.hupeng.service.imp.TopicServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    private TopicServiceImp topicService;

    private String userAccount;

    private HashMap<String, TopicService> topicServiceHashMap = new HashMap<>();

    @RequestMapping(value = "/test",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String test(){
        JSONObject jsonObject;

        if(!this.topicService.endOfTopic()) {
            jsonObject = new JSONObject(topicService.getTopic());
        }else {
            jsonObject = new JSONObject();
            jsonObject.put("error","endOfTopic");
        }
        return jsonObject.toString();
    }
    @ModelAttribute
    public void getUserAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("account") != null) {
            this.userAccount = (String)session.getAttribute("account");
        } else if(request.getCookies() != null) {
            for(Cookie cookie : request.getCookies()) {
                if(cookie.getName().equals("account")) {
                    this.userAccount = cookie.getValue();
                }
            }
        }
    }
}

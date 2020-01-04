package com.hupeng.controller;
import com.hupeng.service.TopicService;
import com.hupeng.service.imp.TopicServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
public class ExaminationController {
    @Autowired
    private TopicServiceImp topicService;

    private String userAccount;

    private static HashMap<String, TopicService> topicServiceHashMap = new HashMap<>();

    @RequestMapping(value = "/test",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String test(){
        JSONObject jsonObject;

        TopicService topicService = topicServiceHashMap.get(userAccount);
        if(!topicService.endOfTopic()) {
            jsonObject = new JSONObject(topicService.getNexTopic());
        }else {
            jsonObject = new JSONObject();
            jsonObject.put("error","endOfTopic");
        }
        return jsonObject.toString();
    }
    @ModelAttribute
    public void init(HttpServletRequest request) {
        if(request.getParameter("account") != null) {
            this.userAccount = request.getParameter("account");
        }
        //为每个用户创建topicServer对象
        if(this.userAccount != null && ExaminationController.topicServiceHashMap.get(this.userAccount) == null) {
            ExaminationController.topicServiceHashMap.put(this.userAccount,topicService);
        }
        System.out.println("账号"+ this.userAccount);
        System.out.println("topicServer" + ExaminationController.topicServiceHashMap.get(userAccount).hashCode());
    }
}

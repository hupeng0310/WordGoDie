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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/examination")
@Scope("prototype")
public class ExaminationController {
    @Autowired
    private TopicServiceImp topicService;

    private String userAccount;

    private static HashMap<String, TopicService> topicServiceHashMap = new HashMap<>();

    @RequestMapping(value = "/topic",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String topic(){
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

    @RequestMapping(value = "/lasttopic",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String lastTopic() {
        JSONObject jsonObject;

        TopicService topicService = ExaminationController.topicServiceHashMap.get(userAccount);
        if(!topicService.topOfTopic()) {
            jsonObject = new JSONObject(topicService.getLastTopic());
        } else {
            jsonObject = new JSONObject();
            jsonObject.put("error","topOfTopic");
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/indexoftopic",produces = "text/json;charset=utf8")
    @ResponseBody
    public String indexOfTopic(int index) {
        TopicService topicService = ExaminationController.topicServiceHashMap.get(this.userAccount);
        return new JSONObject(topicService.getTopicByIndex(index)).toString();
    }

    @RequestMapping("/topicnumber")
    @ResponseBody
    public int getTopicNumber() {
        TopicService topicService = ExaminationController.topicServiceHashMap.get(this.userAccount);
        return topicService.getTopicNumber();
    }

    @ModelAttribute
    public void init(HttpServletRequest request) {
        if(request.getSession().getAttribute("account") != null) {
            this.userAccount = (String)request.getSession().getAttribute("account");
        }
        //为每个用户创建topicServer对象
        if(this.userAccount != null && ExaminationController.topicServiceHashMap.get(this.userAccount) == null) {
            ExaminationController.topicServiceHashMap.put(this.userAccount,topicService);
        }
    }
}

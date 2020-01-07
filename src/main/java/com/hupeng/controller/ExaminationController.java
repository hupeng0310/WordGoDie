package com.hupeng.controller;
import com.hupeng.entity.Topic;
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
    private static HashMap<String,HashMap<Integer,String>> userAnswer = new HashMap<>();

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
        JSONObject jsonObject;
        if(index < 1 || index >topicService.getTopicNumber()) {
            jsonObject = new JSONObject();
            jsonObject.put("error","outOfBounds");
        }else {
            jsonObject = new JSONObject(topicService.getTopicByIndex(index - 1));
        }
        return jsonObject.toString();
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
            ExaminationController.userAnswer.put(userAccount, new HashMap<>());
        }
    }

    @RequestMapping("/gettopicindex")
    @ResponseBody
    public String getTopicIndex() {
        TopicService topicService = ExaminationController.topicServiceHashMap.get(this.userAccount);
        return topicService.getTopicIndex()+"";
    }

    //用户上传答案
    @RequestMapping("/uploadanswer")
    @ResponseBody
    public void uploadAnswer(String index,String answer) {
        HashMap<Integer,String> answers = ExaminationController.userAnswer.get(userAccount);
        answers.put(Integer.parseInt(index),answer);
    }

    @RequestMapping("/handpaper")
    @ResponseBody
    public String handPaper() {
        int score = 0;
        TopicService topicService = ExaminationController.topicServiceHashMap.get(this.userAccount);
        HashMap<Integer,String> answers = ExaminationController.userAnswer.get(this.userAccount);
        for(int i = 0; i < topicService.getTopicNumber();i++) {
            String userAnswer = answers.get(i);
            if (userAnswer != null && topicService.getTopicByIndex(i).getWord().equals(userAnswer)){
            score++;
            }
        }
        ExaminationController.topicServiceHashMap.remove(userAccount);
        return score+"";
    }
}

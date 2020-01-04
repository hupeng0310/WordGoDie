package com.hupeng.controller;
import com.hupeng.service.imp.TopicServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//取消控制器的单例模式
@Scope("prototype")
public class ExaminationController {
    @Autowired
    private TopicServiceImp topicService;

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
}

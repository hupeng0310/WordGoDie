package com.hupeng.controller;

import com.hupeng.entity.Vocabulary;
import com.hupeng.service.imp.VocabularyServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
//取消控制器的单例模式
@Scope("prototype")
public class ExaminationController {
    @Autowired
    private VocabularyServiceImp vocabularyService;

    @RequestMapping(value = "/test",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String test(){
        System.out.println(vocabularyService.countVocabulary());
        JSONObject json = new JSONObject();
        json.put("vocabulary",vocabularyService.selectVocabularyById(0,20));
        return json.toString();
    }
}

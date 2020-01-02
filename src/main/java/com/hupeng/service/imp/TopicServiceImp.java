package com.hupeng.service.imp;

import com.hupeng.dao.Topic;
import com.hupeng.entity.Vocabulary;
import com.hupeng.service.TopicService;
import com.hupeng.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Service("topicService")
public class TopicServiceImp implements TopicService {
    //设置题目的数量
    private static final int MAX_TOPIC_NUMBER = 20;

    //设置单词中最大可缺失的字母比例
    private static final double maxInComplete = 0.5d;

    @Autowired
    VocabularyServiceImp vocabularyService;

    private String getInCompleteWord(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);
        int wordLength = wordBuilder.length();
        //当前单词中真实缺失字母的
        int realInCompleteLength = (int)(Math.random() * wordLength * maxInComplete + 1);
        while(true) {
            //该字符串拷贝用于将随机替换为空格的字符删除，与原字符串比较，判断原字符串缺失的长度是否达到了realInCompleteLength的长度
            String wordCopy = wordBuilder.toString();
            wordCopy = wordCopy.replace(" ","");
            if(wordBuilder.length() - wordCopy.length() < realInCompleteLength) {
                //生成需要隐藏字符的随机数索引
                int ranDomIndex = (int)(Math.random() * wordLength * maxInComplete + 1);
                wordBuilder.replace(ranDomIndex,ranDomIndex + 1," ");
            }else {
                return wordBuilder.toString();
            }
        }
    }

    @Override
    public List<Topic> getTopics() {
        ArrayList<Vocabulary> vocabularies = vocabularyService.getVocabularies(MAX_TOPIC_NUMBER);
        return null;
    }
}

package com.hupeng.service.imp;

import com.hupeng.entity.Topic;
import com.hupeng.entity.Vocabulary;
import com.hupeng.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("topicService")
public class TopicServiceImp implements TopicService {
    //设置题目的数量
    private static final int MAX_TOPIC_NUMBER = 20;

    //设置单词中最大可缺失的字母比例
    private static final double maxInComplete = 0.5d;

    private ArrayList<Topic> topicList = new ArrayList<>();

    //指向topicList中下一个可以获取的单词对象的游标
    private int topicIndex = 0;

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
                int ranDomIndex = (int)(Math.random() * wordLength);
                wordBuilder.replace(ranDomIndex,ranDomIndex + 1," ");
            }else {
                return wordBuilder.toString();
            }
        }
    }

    private Topic produceTopic(Vocabulary vocabulary) {
        Topic topic = new Topic();
        if(vocabulary.getInterpretation_nd() != null && vocabulary.getPart_of_speech_nd() != null) {
            //随机选择具有两个释义的单词中的一个作为topic的释义
            //为1时选择第二个释义
            int choiceContext = (int)(Math.random() + 0.5);
            if(choiceContext ==1) {
                topic.setWord(vocabulary.getWord());
                topic.setIncompleteWord(getInCompleteWord(vocabulary.getWord()));
                topic.setInterpretation(vocabulary.getInterpretation_nd());
                topic.setPartOfSpeech(vocabulary.getPart_of_speech_nd());
                return topic;
            }
        }
        topic.setWord(vocabulary.getWord());
        topic.setIncompleteWord(getInCompleteWord(vocabulary.getWord()));
        topic.setInterpretation(vocabulary.getInterpretation());
        topic.setPartOfSpeech(vocabulary.getPart_of_speech());
        return topic;
    }

    private void initTopicList() {
        for(Vocabulary vocabulary:vocabularyService.getVocabularies(MAX_TOPIC_NUMBER)) {
            this.topicList.add(produceTopic(vocabulary));
        }
    }

    @Override
    public boolean endOfTopic() {
        if(this.topicList == null || this.topicList.size() == 0) {
            initTopicList();
        }
        return this.topicIndex >= this.topicList.size();
    }

    @Override
    public Topic getTopic() {
        return this.topicList.get(this.topicIndex++);
    }
}

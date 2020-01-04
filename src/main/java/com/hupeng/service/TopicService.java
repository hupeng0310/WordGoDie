package com.hupeng.service;

import com.hupeng.entity.Topic;

public interface TopicService {
     boolean endOfTopic();
     Topic getNexTopic();
     Topic getLastTopic();
     Topic getTopicByIndex(int index);
     int getTopicNumber();
}

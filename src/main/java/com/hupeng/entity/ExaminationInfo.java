package com.hupeng.entity;

import java.util.Date;

public class ExaminationInfo {
    private int id;
    private int pass_topic;
    private int topic_num;
    private Date hand_date;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPass_topic() {
        return pass_topic;
    }

    public void setPass_topic(int pass_topic) {
        this.pass_topic = pass_topic;
    }

    public int getTopic_num() {
        return topic_num;
    }

    public void setTopic_num(int topic_num) {
        this.topic_num = topic_num;
    }

    public Date getHand_date() {
        return hand_date;
    }

    public void setHand_date(Date hand_date) {
        this.hand_date = hand_date;
    }
}

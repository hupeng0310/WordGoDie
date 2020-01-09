package com.hupeng.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserExaminationInfo {
    private String account;
    private int pass_topic;
    private int topic_num;
    private Date hand_date;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getHand_date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.hand_date);
    }

    public void setHand_date(Date hand_date) {
        System.out.println("测试");
        this.hand_date = hand_date;
    }
}

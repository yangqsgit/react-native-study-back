package com.example.reactNativeStudy.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

public class User {
    @Id
    @Field("_id")
    private String id;
    private String name;
    private Date createTime;
    private String account;
    private String pwd;
    private UserBaseInfo baseInfo;

    private List<String> sessionIds;

    public User() {
    }



    public User(String account) {
        this.account = account;
    }

    public User(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                ", account='" + account + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getAccount() {
        return account;
    }

    public UserBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSessionIds() {
        return sessionIds;
    }

    public void setSessionIds(List<String> sessionIds) {
        this.sessionIds = sessionIds;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setBaseInfo(UserBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }
}

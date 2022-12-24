package com.example.reactNativeStudy.Vo;

import com.example.reactNativeStudy.Entity.UserBaseInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

public class UserResponseDto {
    @Id
    @Field("_id")
    private String id;
    private String name;
    private Date createTime;
    private String account;
    private UserBaseInfo baseInfo;

    private List<String> sessionIds;

    public UserResponseDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBaseInfo(UserBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public void setSessionIds(List<String> sessionIds) {
        this.sessionIds = sessionIds;
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

    public List<String> getSessionIds() {
        return sessionIds;
    }

    public UserResponseDto(String id, String name, Date createTime, String account, UserBaseInfo baseInfo, List<String> sessionIds) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.account = account;
        this.baseInfo = baseInfo;
        this.sessionIds = sessionIds;
    }
}

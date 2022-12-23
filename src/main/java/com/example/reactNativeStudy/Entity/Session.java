package com.example.reactNativeStudy.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class Session {
    @Id
    @Field("_id")
    private String id;
    private Date createTime;
    private String ceatorId;
    private String reciverId;

    public Session() {
    }

    public void setCeatorId(String ceatorId) {
        this.ceatorId = ceatorId;
    }

    public void setReciverId(String reciverId) {
        this.reciverId = reciverId;
    }

    public Session(String ceatorId, String reciverId) {
        this.ceatorId = ceatorId;
        this.reciverId = reciverId;
        this.createTime = new Date();
    }
}

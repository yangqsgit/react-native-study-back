package com.example.reactNativeStudy.Entity;

import java.net.URI;

public class UserBaseInfo {
    private Number sex;
    private Number age;
    private String address;
    private String signature;
    private String phoneNumber;

    private URI bgUrl;

    private URI headUrl;

    public UserBaseInfo() {
    }

    @Override
    public String toString() {
        return "UserBaseInfo{" +
                "sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", signature='" + signature + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bgUrl=" + bgUrl +
                ", headUrl=" + headUrl +
                '}';
    }

    public URI getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(URI bgUrl) {
        this.bgUrl = bgUrl;
    }

    public void setSex(Number sex) {
        this.sex = sex;
    }

    public void setAge(Number age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHeadUrl(URI headUrl) {
        this.headUrl = headUrl;
    }
}

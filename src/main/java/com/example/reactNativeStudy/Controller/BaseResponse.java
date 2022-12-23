package com.example.reactNativeStudy.Controller;



public class BaseResponse<T> {
    public String message;
    public T data;
    public Boolean success;

    public BaseResponse() {
    }

    public BaseResponse(String message, T data, Boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }


}

package com.example.meconnect.common.output;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> implements Serializable{

    private static final long serialVersionUID = -146901462068140618L;

    @JsonProperty("data")
    private T data;

    @JsonProperty("responseMessage")
    private String  responseMessage;

    @JsonProperty("responseCode")
    private String  responseCode;

 

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String getResponseCode() {
        return responseCode;
    }


    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

  

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

}

package com.example.meconnect.common.input;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    @JsonProperty("inputData")
    private T object;

    @JsonProperty("authToken")
    private String authToken;

    public T getObject()
    {
        return object;
    }

    public void setObject(T object)
    {
        this.object = object;
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

}

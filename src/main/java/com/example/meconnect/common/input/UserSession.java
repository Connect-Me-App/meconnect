package com.example.meconnect.common.input;

import java.io.Serializable;


public class UserSession implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String password;

    private String fullName;

    private String photo;

    private String authToken;

    public String getFullName()
    {
        return fullName;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }



    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }


}

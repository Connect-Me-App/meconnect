package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//import com.meConnect2.meConnect2.entity.Usersentity;

public class myUserDetails implements UserDetails {

    private User usersEntity = null;


    public myUserDetails() {
        super();
    }

    public myUserDetails(User usersEntity) {
        super();
        this.usersEntity = usersEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return usersEntity.getPasswordHash();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return usersEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        //return usersEntity.getIs_active();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        //return usersEntity.getIs_active();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
       // return usersEntity.getIs_active();
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return usersEntity.getIs_active();
    }

}

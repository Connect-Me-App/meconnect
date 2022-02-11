package com.example.meconnect.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.meconnect.entity.Usersentity;

//import com.meConnect2.meConnect2.entity.Usersentity;

public class myUserDetails implements UserDetails {
    
	 private Usersentity usersEntity=null; 
	
	
	public myUserDetails() {
		super();
	}

	public myUserDetails(Usersentity usersEntity) {
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
		return usersEntity.getIs_active();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return usersEntity.getIs_active();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return usersEntity.getIs_active();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return usersEntity.getIs_active();
	}

}

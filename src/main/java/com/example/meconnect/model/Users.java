package com.example.meconnect.model;

import java.util.Date;


public class Users {
	
   private Long id;
   private String first_name;
   private String middle_name;
   private String last_name;
   private String username;
   private String mobile_no;
   private String email;
   private String passwordHash;
   private Date registered_at;
   private Date last_login;
   private String address;
   private Boolean is_active;
   private Date creation_dt;
   private Date updation_dt;
   private String created_by;
   private String updated_by;
   
   
   public Users(Long id, String first_name, String middle_name, String last_name, String username, String mobile_no,
			String email, String passwordHash, Date registered_at, Date last_login, String address, Boolean is_active,
			Date creation_dt, Date updation_dt, String created_by, String updated_by) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.username = username;
		this.mobile_no = mobile_no;
		this.email = email;
		this.passwordHash = passwordHash;
		this.registered_at = registered_at;
		this.last_login = last_login;
		this.address = address;
		this.is_active = is_active;
		this.creation_dt = creation_dt;
		this.updation_dt = updation_dt;
		this.created_by = created_by;
		this.updated_by = updated_by;
	}


	@Override
public String toString() {
	return "Users [id=" + id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
			+ last_name + ", username=" + username + ", mobile_no=" + mobile_no + ", email=" + email + ", passwordHash="
			+ passwordHash + ", registered_at=" + registered_at + ", last_login=" + last_login + ", address=" + address
			+ ", is_active=" + is_active + ", creation_dt=" + creation_dt + ", updation_dt=" + updation_dt
			+ ", created_by=" + created_by + ", updated_by=" + updated_by + "]";
}


	public Users() {
		super();
	}
	   
   
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getMiddle_name() {
	return middle_name;
}
public void setMiddle_name(String middle_name) {
	this.middle_name = middle_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMobile_no() {
	return mobile_no;
}
public void setMobile_no(String mobile_no) {
	this.mobile_no = mobile_no;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPasswordHash() {
	return passwordHash;
}
public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}
public Date getRegistered_at() {
	return registered_at;
}
public void setRegistered_at(Date registered_at) {
	this.registered_at = registered_at;
}
public Date getLast_login() {
	return last_login;
}
public void setLast_login(Date last_login) {
	this.last_login = last_login;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Boolean getIs_active() {
	return is_active;
}
public void setIs_active(Boolean is_active) {
	this.is_active = is_active;
}
public Date getCreation_dt() {
	return creation_dt;
}
public void setCreation_dt(Date creation_dt) {
	this.creation_dt = creation_dt;
}     
public Date getUpdation_dt() {
	return updation_dt;
}
public void setUpdation_dt(Date updation_dt) {
	this.updation_dt = updation_dt;
}
public String getCreated_by() {
	return created_by;
}
public void setCreated_by(String created_by) {
	this.created_by = created_by;
}
public String getUpdated_by() {
	return updated_by;
}
public void setUpdated_by(String updated_by) {
	this.updated_by = updated_by;
}

}

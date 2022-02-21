package com.example.meconnect.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_no")
    private String mobile_no;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordHash")
    private String passwordHash;

    @Column(name = "registered_at")
    private Date registered_at;

    @CreationTimestamp
    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "address")
    private String address;

    @Column(name = "is_active")
    private Boolean is_active;


    @CreationTimestamp
    @Column(name = "creation_dt", nullable = false, updatable = false)
    private Date creation_dt;

    @UpdateTimestamp
    @Column(name = "updated_dt")
    private Date updation_dt;


    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "city")
    private String city;

    @Column(name = "education")
    private String  education;
    @Column(name = "dob")
    private  String dob;
    @Column(name = "country")
    private String country;

    @Column(name = "aboutyou")
    private String aboutyou;

//    public User() {
//        super();
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getMiddle_name() {
//        return middle_name;
//    }
//
//    public void setMiddle_name(String middle_name) {
//        this.middle_name = middle_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getMobile_no() {
//        return mobile_no;
//    }
//
//    public void setMobile_no(String mobile_no) {
//        this.mobile_no = mobile_no;
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPasswordHash() {
//        return passwordHash;
//    }
//
//    public void setPasswordHash(String passwordHash) {
//        this.passwordHash = passwordHash;
//    }
//
//    public Date getRegistered_at() {
//        return registered_at;
//    }
//
//    public void setRegistered_at(Date registered_at) {
//        this.registered_at = registered_at;
//    }
//
//    public Date getLast_login() {
//        return last_login;
//    }
//
//    public void setLast_login(Date last_login) {
//        this.last_login = last_login;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public Boolean getIs_active() {
//        return is_active;
//    }
//
//    public void setIs_active(Boolean is_active) {
//        this.is_active = is_active;
//    }
//
//    public Date getCreation_dt() {
//        return creation_dt;
//    }
//
//    public void setCreation_dt(Date creation_dt) {
//        this.creation_dt = creation_dt;
//    }
//
//    public Date getUpdation_dt() {
//        return updation_dt;
//    }
//
//    public void setUpdation_dt(Date updation_dt) {
//        this.updation_dt = updation_dt;
//    }
//
//    public String getCreated_by() {
//        return created_by;
//    }
//
//    public void setCreated_by(String created_by) {
//        this.created_by = created_by;
//    }
//
//    public String getUpdated_by() {
//        return updated_by;
//    }
//
//    public void setUpdated_by(String updated_by) {
//        this.updated_by = updated_by;
  // }

}

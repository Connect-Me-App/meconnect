package com.example.meconnect.service;

import java.util.List;

import com.example.meconnect.entity.Usersentity;
//import com.meConnect2.meConnect2.model.Users;
import com.example.meconnect.model.Users;

//import com.meConnect2.meConnect2.entity.Usersentity;
//import com.meConnect2.meConnect2.model.Users;

public interface Usersservice {
      Usersentity  saveUser(Users user); 
      void  deleteUser(Long id);
      Usersentity getUser(Long id);
      Usersentity getUserByUserName(String username);
      List<Usersentity> getUser();
      void  updateuser(Users user, Long id);
}

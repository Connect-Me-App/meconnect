package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.VerificationToken;
import com.example.meconnect.model.Users;

import java.util.List;

//import com.meConnect2.meConnect2.entity.Usersentity;
//import com.meConnect2.meConnect2.model.Users;

public interface Usersservice {
    User saveUser(Users user);

    void deleteUser(Long id);

    User getUser(Long id);

    User getUserByUserName(String username);

    List<User> getUser();
    VerificationToken verification(String token);
    void updateuser(Users user, Long id);
    public void deleteToken(String token);
}

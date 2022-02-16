package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import com.example.meconnect.model.Users;
import com.example.meconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//import com.meConnect2.meConnect2.entity.Usersentity;
//import com.meConnect2.meConnect2.model.Users;
//import com.meConnect2.meConnect2.repository.UserRepository;
//import com.meConnect2.meConnect2.service.Usersservice;

@Service
public class Usersserviceimpl implements Usersservice {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(Users user) {
        // TODO Auto-generated method stub
        User usersEntity = new User();
        usersEntity.setFirst_name(user.getFirst_name());
        usersEntity.setMiddle_name(user.getMiddle_name());
        usersEntity.setLast_name(user.getLast_name());
        usersEntity.setAddress(user.getAddress());
        usersEntity.setEmail(user.getEmail());
        usersEntity.setMobile_no(user.getMobile_no());
        usersEntity.setIs_active(user.getIs_active());
        usersEntity.setPasswordHash(user.getPasswordHash());
        usersEntity.setUsername(user.getUsername());
        Date registerDate = new Date();
        usersEntity.setRegistered_at(registerDate);

        return userRepository.save(usersEntity);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User getUser(Long id) {
        //  Usersentity user= userRepository.getById(id);
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }


    @Override
    public User getUserByUserName(String username) {
        User userentity = userRepository.findUserByUsername(username);

        return userentity;
    }


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }


    @Override
    public void updateuser(Users user, Long id) {

        User usersEntity = new User();
        usersEntity.setId(id);
        usersEntity.setFirst_name(user.getFirst_name());
        usersEntity.setMiddle_name(user.getMiddle_name());
        usersEntity.setLast_name(user.getLast_name());
        usersEntity.setAddress(user.getAddress());
        usersEntity.setEmail(user.getEmail());
        usersEntity.setMobile_no(user.getMobile_no());
        usersEntity.setIs_active(user.getIs_active());
        usersEntity.setPasswordHash(user.getPasswordHash());
        usersEntity.setUsername(user.getUsername());

        userRepository.save(usersEntity);

    }


}

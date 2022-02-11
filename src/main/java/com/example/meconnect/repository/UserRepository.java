package com.example.meconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meconnect.entity.Usersentity;

//import com.meConnect2.meConnect2.entity.Usersentity;

public interface UserRepository extends JpaRepository<Usersentity,Long> {
         Usersentity findUserByUsername(String username);
}

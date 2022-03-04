package com.example.meconnect.repository;

import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//import com.meConnect2.meConnect2.entity.Usersentity;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

}

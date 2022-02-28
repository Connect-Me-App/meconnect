package com.example.meconnect.repository;

import com.example.meconnect.entity.Likes;
import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    //Likes findByPostandUser(Post post, User user);


    Optional<Likes> findTopByPostAndUserOrderByIdDesc(Post post, User currentUser);

}

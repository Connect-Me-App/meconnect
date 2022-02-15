package com.example.meconnect.repository;

import com.example.meconnect.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {


    ArrayList<Comment> findAllByPostId(long postId);

    Comment save(Comment comment);

}

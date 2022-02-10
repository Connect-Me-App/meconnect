package com.example.meconnect.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.meconnect.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	
	ArrayList<Comment> findAllByPostID(long postId);
	Comment save(Comment comment);
	
}

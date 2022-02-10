package com.example.meconnect.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.meconnect.entity.Post;


@Repository
public interface PostRepo extends JpaRepository<Post, Long>{
	
	ArrayList<Post> findAll();
	Post save(Post post);
	void deleteById(long postId);
	
}
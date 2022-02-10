package com.example.meconnect.service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meconnect.entity.Post;
import com.example.meconnect.repository.PostRepo;

@Service
public class PostService {
	
	@Autowired
	PostRepo postRepo;
	
	public ArrayList<Post> submitPostToDB(Post postData){
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp dateTime = new Timestamp(time);
		
		postData.setUpdationBy(postData.getUserName());
		postData.setLikeCount(0);
		postData.setCreatedDt(dateTime);
		postData.setUpdationDt(dateTime);
		postData.setCreatedBy(postData.getUserName());
		postRepo.save(postData);
		ArrayList<Post> result = retrievePostFromDB();
		return result;
	}
	
	public ArrayList<Post> retrievePostFromDB(){
		ArrayList<Post> result = postRepo.findAll();
		return result;
	}
	
	public ArrayList<Post> deletePostFromDB(long postId){
		postRepo.deleteById(postId);
		ArrayList<Post> result = retrievePostFromDB();
		return result;
	}
}

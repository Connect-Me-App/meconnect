package com.example.meconnect.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.meconnect.entity.Post;
import com.example.meconnect.service.PostService;

@RestController
@RequestMapping(path = "/api/postService")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ArrayList<Post> submitPost(@RequestBody Post body){
		ArrayList<Post> result = postService.submitPostToDB(body);
		return result;
	}
	
	@RequestMapping(value = "/getPost", method = RequestMethod.GET)
	public ArrayList<Post> retreiveAllPost(){
		ArrayList<Post> result = postService.retrievePostFromDB();
		return result;
	}
	
	@RequestMapping(value = "/delete/{postId}", method = RequestMethod.DELETE)
	public ArrayList<Post> deletePost(@PathVariable("postId") long postId){
		ArrayList<Post> result = postService.deletePostFromDB(postId);
 		return result;
	}
	
}

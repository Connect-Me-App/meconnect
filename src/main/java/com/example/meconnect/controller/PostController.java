package com.example.meconnect.controller;

import com.example.meconnect.entity.Post;
import com.example.meconnect.model.PostRequest;
import com.example.meconnect.model.PostResponse;
import com.example.meconnect.service.PostService;
import com.example.meconnect.service.myUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private myUserDetailService userDetailService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {

        System.out.println(" this is working fine line 30");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        postRequest.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        postService.submitPostToDB(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> retrieveAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @RequestMapping(value = "/by-user/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<PostResponse>> retrievePostByUsername(@PathVariable String username) {
        return status(HttpStatus.OK).body(postService.getAllPostsByUsername(username));
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePostById(@PathVariable Long postId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        postService.deletePost(username, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId){
        return status(HttpStatus.OK).body(postService.getPost(postId));
    }


}

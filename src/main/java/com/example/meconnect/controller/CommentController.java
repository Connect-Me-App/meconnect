package com.example.meconnect.controller;

import com.example.meconnect.model.CommentRequest;
import com.example.meconnect.model.CommentResponse;
import com.example.meconnect.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createComment(@RequestBody CommentRequest comment) {
        comment.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commentService.submitCommentToDB(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getAllComments/{postId}", method = RequestMethod.GET)
    public ResponseEntity<List<CommentResponse>> getCommentsByPostId(@PathVariable Long postId){
        return status(HttpStatus.OK).body(commentService.getCommentsByPostId(postId));
    }

    @RequestMapping(value = "/{postId}/{commentId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByCommentId(@PathVariable Long postId, @PathVariable Long commentId){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.deleteByCommentId(username,postId,commentId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

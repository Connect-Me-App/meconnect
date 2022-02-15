package com.example.meconnect.controller;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/api/commentService")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @RequestMapping(value = "/getAllComments/{postId}", method = RequestMethod.GET)
    public ArrayList<Comment> getAllComments(@PathVariable("postId") long postId) {
        return commentService.getAllComment(postId);
    }

}

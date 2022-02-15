package com.example.meconnect.service;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public Comment saveComment(Comment comment) {

        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);

        comment.setCreationDate(dateTime);
        comment.setUpdationDate(dateTime);
        comment.setLikes_count(0);
        return commentRepo.save(comment);
    }

    public ArrayList<Comment> getAllComment(long postId) {
        return commentRepo.findAllByPostId(postId);
    }
}

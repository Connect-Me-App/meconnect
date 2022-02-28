package com.example.meconnect.controller;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.Post;
import com.example.meconnect.model.LikeCommentRequest;
import com.example.meconnect.model.LikeRequest;
import com.example.meconnect.service.LikesCommentService;
import com.example.meconnect.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LikesCommentController {
    @Autowired
    private LikesCommentService likesCommentService;

    @PostMapping("/likeCommentdata/")
    public ResponseEntity<?> like(@RequestBody LikeCommentRequest likesdto) {
        Comment comment = null;

        try {
            comment = likesCommentService.save(likesdto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}

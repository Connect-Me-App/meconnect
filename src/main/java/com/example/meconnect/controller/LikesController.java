package com.example.meconnect.controller;

import com.example.meconnect.entity.Post;
import com.example.meconnect.model.LikeRequest;
import com.example.meconnect.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/like")
public class LikesController {

    @Autowired
    private LikesService likeService;

    @PostMapping("/likedata")
    public ResponseEntity<?> like(@RequestBody LikeRequest likesdto) {
        Post post = null;

        try {
            post = likeService.save(likesdto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}

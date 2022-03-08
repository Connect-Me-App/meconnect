package com.example.meconnect.controller;

import com.example.meconnect.entity.Post;
import com.example.meconnect.model.LikeRequest;
import com.example.meconnect.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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


    @GetMapping("/alreadylikeOrNot")
    public ResponseEntity<?> likeAlreadyorNot(@RequestBody LikeRequest likesdto) {

        if (likesdto.getPostid() == null) {
            return new ResponseEntity<>("please send the post id ", HttpStatus.NOT_FOUND);
        }

        boolean check = likeService.checklikeorNot(likesdto);

        if (check == false) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}

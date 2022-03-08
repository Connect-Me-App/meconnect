package com.example.meconnect.service;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.LikesComment;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.LikeCommentRequest;
import com.example.meconnect.repository.CommentRepo;
import com.example.meconnect.repository.LikesCommentRepository;
import com.example.meconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LikesCommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    LikesCommentRepository likesCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationService notificationService;

    public Comment save(LikeCommentRequest likedata) throws Exception {

        if (likedata.getCommentId() == null) {
            throw new Exception("postid cannot be null");
        }

        Optional<Comment> comment = commentRepo.findById(likedata.getCommentId());

//		    if(post.isEmpty()) {
//		    	throw new Exception("postid not exit in database "+likedata.getPostid());
//		    }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(username);
        Optional<LikesComment> like = likesCommentRepository.findTopByCommentAndUserOrderByIdDesc(comment.get(), user);


        if (like.isPresent() && like.get().getLikeType() == likedata.getLiketype()) {
            throw new Exception(" you already from the operation " + likedata);
        }


        if (likedata.getLiketype() == 1) {
            comment.get().setLikes_count(comment.get().getLikes_count() + 1);
        } else {
            comment.get().setLikes_count(comment.get().getLikes_count() - 1);
        }


        commentRepo.save(comment.get());

        LikesComment likesavedata = new LikesComment();
        likesavedata.setComment(comment.get());
        likesavedata.setUser(user);
        likesavedata.setLikeType(likedata.getLiketype());

        if (like.isPresent()) {
            likesavedata.setId(like.get().getId());
        }
        likesCommentRepository.save(likesavedata);

        notificationService.insertNotification("LIKE_ON_COMMENT", likesavedata.getUser().getUsername(), likesavedata.getComment().getPost().getPostId(), likesavedata.getCreatedAt());
        return comment.get();
    }


}

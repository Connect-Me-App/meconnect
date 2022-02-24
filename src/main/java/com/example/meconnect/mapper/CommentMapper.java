package com.example.meconnect.mapper;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.CommentRequest;
import com.example.meconnect.model.CommentResponse;
import com.example.meconnect.service.PostService;
import com.example.meconnect.service.Usersservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentMapper {

    @Autowired
    PostService postService;

    @Autowired
    Usersservice userService;

    public Comment dtoToDao(CommentRequest comment) {
        Post post = postService.getPostByPostId(comment.getPostId());
        User user = userService.getUserByUserName(comment.getUserName());
        return Comment.builder()
                .post(post)
                .user(user)
                .commentText(comment.getText())
                .likes_count(0)
                .build();
    }


    public CommentResponse daoToDto(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPost().getPostId())
                .text(comment.getCommentText())
                .createdBy(comment.getUser().getUsername())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .likeCount(comment.getLikes_count())
                .userName(comment.getUser().getUsername())
                .build();
    }
}
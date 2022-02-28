package com.example.meconnect.service;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.Post;
import com.example.meconnect.mapper.CommentMapper;
import com.example.meconnect.model.CommentRequest;
import com.example.meconnect.model.CommentResponse;
import com.example.meconnect.repository.CommentRepo;
import com.example.meconnect.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    NotificationService notificationService;

    public void submitCommentToDB(CommentRequest commentReq) {
        Comment comment = commentMapper.dtoToDao(commentReq); //saving model to entity
        comment.setDeleted(false);
        comment.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        commentRepo.save(comment);
        notificationService.insertNotification("COMMENT_ON_POST", commentReq.getUserName(), commentReq.getPostId(), commentReq.getCreatedAt());
    }

    public List<CommentResponse> getCommentsByPostId(Long postId) {
        Post post = postRepo.findByPostIdAndIsDeletedFalse(postId);
        if (post == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post doesn't exist");
        return commentRepo.findAllByPostAndIsDeletedFalse(post)
                .stream()
                .map(commentMapper::daoToDto)
                .collect(Collectors.toList());
    }

    public void deleteByCommentId(String username, Long postId, Long commentId) {
        if (postId == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post does not exist");
        if (commentId == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment does not exist");
        commentRepo.deleteByCommentIdAndPostId(username, postId, commentId);
    }
}

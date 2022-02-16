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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    private final CommentMapper commentMapper;

    public void submitCommentToDB(CommentRequest commentReq) {
        Comment comment = commentMapper.dtoToDao(commentReq); //saving model to entity
        comment.setDeleted(false);
        comment.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        commentRepo.save(comment);
    }

    public List<CommentResponse> getCommentsByPostId(Long postId){
        Post post = postRepo.findByPostIdAndIsDeletedFalse(postId);
        return commentRepo.findAllByPostAndIsDeletedFalse(post)
                .stream()
                .map(commentMapper::daoToDto)
                .collect(Collectors.toList());
    }

    public void deleteByCommentId(String username, Long postId, Long commentId){
        commentRepo.deleteByCommentIdAndPostId(username,postId,commentId);
    }
}

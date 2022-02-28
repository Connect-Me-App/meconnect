package com.example.meconnect.service;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.mapper.PostMapper;
import com.example.meconnect.model.PostRequest;
import com.example.meconnect.model.PostResponse;
import com.example.meconnect.repository.PostRepo;
import com.example.meconnect.repository.UserRepository;
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
public class PostService {

    private final PostMapper postMapper;
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepository userRepository;

    public void submitPostToDB(PostRequest postRequest) {
        Post post = postMapper.dtoToDao(postRequest);
        post.setDeleted(false);
        post.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        postRepo.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepo.findAllByIsDeletedFalse()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getAllPostsByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username doesn't exist");
        return postRepo.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deletePost(String username, Long postId) {
        if (postId == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post doesn't exist");
        postRepo.deleteByUserNameAndPostId(username, postId);
    }

    public Post getPostByPostId(Long postId) {
        Post post = postRepo.findByPostIdAndIsDeletedFalse(postId);
        if (postId == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post doesn't exist");
        return post;
    }


}

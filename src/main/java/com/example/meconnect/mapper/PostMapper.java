package com.example.meconnect.mapper;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.PostRequest;
import com.example.meconnect.model.PostResponse;
import com.example.meconnect.service.Usersservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostMapper {

    private final Usersservice usersservice;

    public Post dtoToDao(PostRequest postRequest) {
        User user = usersservice.getUserByUserName(postRequest.getUserName());
        return Post.builder()
                .user(user)
                .postText(postRequest.getPostText())
                .postImageURL(postRequest.getPostImageURL())
                .postVideoURL(postRequest.getPostVideoURL())
                .likeCount(0)
                .build();
    }

    public PostResponse mapToDto(Post post) {
        return PostResponse.builder()
                .postId(post.getPostId())
                .userName(post.getUser().getUsername())
                .postText(post.getPostText())
                .postImageUrl(post.getPostImageURL())
                .postVideoUrl(post.getPostVideoURL())
                .likeCount(post.getLikeCount())
                .createdBy(post.getUser().getUsername())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}

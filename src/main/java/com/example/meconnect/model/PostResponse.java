package com.example.meconnect.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {

    private Long postId;
    private String postText;
    private String postImageUrl;
    private String postVideoUrl;
    private int likeCount;
    private int commentCount;
    private String userName;
    private String createdBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
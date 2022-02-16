package com.example.meconnect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    private Long id;
    private Long postId;
    private String text;
    private String createdBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int likeCount;
    private String userName;
}

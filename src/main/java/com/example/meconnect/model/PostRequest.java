package com.example.meconnect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    @NotNull
    private String postText;
    @NotNull
    private String postImageURL;
    @NotNull
    private String postVideoURL;
    private String userName;
}
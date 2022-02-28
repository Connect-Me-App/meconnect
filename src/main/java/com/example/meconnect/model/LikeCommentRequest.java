package com.example.meconnect.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikeCommentRequest {

    private int liketype;
    private Long commentId;

}

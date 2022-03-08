package com.example.meconnect.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikeRequest {


    private int liketype;
    private Long postid;


//    public int getLiketype() {
//		return liketype;
//	}
//	public void setLiketype(int liketype) {
//		this.liketype = liketype;
//	}
//	public Long getPostid() {
//		return postid;
//	}
//	public void setPostid(Long postid) {
//		this.postid = postid;
//	}


}

package com.example.meconnect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

package com.example.meconnect.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user_post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long postId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	public Post() {
		
	}
	
	public Post(long postId, Long userId, String userName, String postText, String postImageURL, String postVideoURL,
			int likeCount, String createdBy, String updationBy, Timestamp createdDt, Timestamp updationDt) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.userName = userName;
		this.postText = postText;
		this.postImageURL = postImageURL;
		this.postVideoURL = postVideoURL;
		this.likeCount = likeCount;
		this.createdBy = createdBy;
		this.updationBy = updationBy;
		this.createdDt = createdDt;
		this.updationDt = updationDt;
	}


	@Column(name = "post_text")
	private String postText;
	
	@Column(name = "post_image_url")
	private String postImageURL;
	
	@Column(name = "post_video_url")
	private String postVideoURL;

	@Column(name = "like_count")
	private int likeCount;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updationBy;
	
	@Column(name = "creation_dt")
	private Timestamp createdDt;
	
	@Column(name = "updation_dt")
	private Timestamp updationDt;
	
	public Timestamp getCreatedDt() {
		return createdDt;
	}


	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}


	public Timestamp getUpdationDt() {
		return updationDt;
	}


	public void setUpdationDt(Timestamp updationDt) {
		this.updationDt = updationDt;
	}
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdationBy() {
		return updationBy;
	}


	public void setUpdationBy(String updationBy) {
		this.updationBy = updationBy;
	}


	public long getPostId() {
		return postId;
	}


	public void setPostId(long postId) {
		this.postId = postId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getPostText() {
		return postText;
	}


	public void setPostText(String postText) {
		this.postText = postText;
	}


	public String getPostImageURL() {
		return postImageURL;
	}


	public void setPostImageURL(String postImageURL) {
		this.postImageURL = postImageURL;
	}


	public String getPostVideoURL() {
		return postVideoURL;
	}


	public void setPostVideoURL(String postVideoURL) {
		this.postVideoURL = postVideoURL;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}


	
	
}


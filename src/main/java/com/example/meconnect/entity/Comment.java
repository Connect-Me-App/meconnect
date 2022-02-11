package com.example.meconnect.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "post_id")
	private Long postId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "likes_count")
	private int likes_count;
	
	@Column(name = "creation_dt")
	private Timestamp creationDate;
	
	@Column(name = "updation_dt")
	private Timestamp updationDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;

	public Comment(Long id, Long postId, Long userId, String text, int likes_count, Timestamp creationDate,
			Timestamp updationDate, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.text = text;
		this.likes_count = likes_count;
		this.creationDate = creationDate;
		this.updationDate = updationDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLikes_count() {
		return likes_count;
	}

	public void setLikes_count(int likes_count) {
		this.likes_count = likes_count;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Timestamp updationDate) {
		this.updationDate = updationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Comment() {
		super();
	}
	
}

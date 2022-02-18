package com.example.meconnect.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Likes {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
   private Long id;
	
   private int likeType;
   
   @ManyToOne
   @JoinColumn(name = "postid", referencedColumnName = "id")
   private  Post post;
   
   @ManyToOne
   @JoinColumn(name = "userid", referencedColumnName = "username")
   private User  user;
//
//public Long getId() {
//	return id;
//}
//
//public void setId(Long id) {
//	this.id = id;
//}
//
//public int getLikeType() {
//	return likeType;
//}
//
//public void setLikeType(int likeType) {
//	this.likeType = likeType;
//}
//
//public Post getPost() {
//	return post;
//}
//
//public void setPost(Post post) {
//	this.post = post;
//}
//
//public User getUser() {
//	return user;
//}
//
//public void setUser(User user) {
//	this.user = user;
//}
   
}

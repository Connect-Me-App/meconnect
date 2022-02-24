package com.example.meconnect.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

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
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "username")
    private User user;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

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

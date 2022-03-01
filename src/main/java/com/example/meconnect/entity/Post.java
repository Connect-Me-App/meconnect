package com.example.meconnect.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@Table(name = "user_post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", referencedColumnName = "username")
    private User user;

    @NotNull
    @Column(name = "post_text")
    private String postText;

    @NotNull
    @Column(name = "post_image_url")
    private String postImageURL;

    @NotNull
    @Column(name = "post_video_url")
    private String postVideoURL;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

}


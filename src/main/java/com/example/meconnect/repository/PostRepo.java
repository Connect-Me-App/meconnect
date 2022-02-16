package com.example.meconnect.repository;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

//    @Query(value = "SELECT * FROM user_post WHERE isDeleted = 0 ",nativeQuery = true)
    List<Post> findAllByIsDeletedFalse();

    Post save(Post post);

    List<Post> findByUser(User user);

    Post findByPostIdAndIsDeletedFalse(Long postId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_post p SET p.is_deleted = 1 WHERE  p.id = ?2 AND p.user_name = ?1",nativeQuery = true)
    void deleteByUserNameAndPostId(String username,Long postId);
}
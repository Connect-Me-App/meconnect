package com.example.meconnect.repository;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {


    @Query(value = "SELECT p.* FROM user_post p JOIN friendship f ON p.?1 = f.user_sender" +
            " WHERE f.is_friend = 1 AND p.is_deleted=0" +
            " UNION" +
            " SELECT p.* FROM user_post p" +
            " JOIN friendship f ON p.?1 = f.user_receiver" +
            " WHERE f.is_friend = 1 AND p.is_deleted=0" +
            " ORDER BY created_at DESC;", nativeQuery = true)
    List<Post> getAllPost(String userName);

    Post save(Post post);

    List<Post> findByUser(User user);

    Post findByPostIdAndIsDeletedFalse(Long postId);


    @Modifying
    @Query(value = "UPDATE user_post p SET p.is_deleted = 1 WHERE  p.id = ?2 AND p.user_name = ?1", nativeQuery = true)
    void deleteByUserNameAndPostId(String username, Long postId);
}
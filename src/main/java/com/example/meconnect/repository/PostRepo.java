package com.example.meconnect.repository;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAll();

    Post save(Post post);

    void deleteById(long postId);

    List<Post> findByUser(User user);

    @Modifying
    @Query(value = "DELETE FROM user_post WHERE id=?1 AND user_name=?2",nativeQuery = true)
    void deleteByPostIdAndUsername(Long postId, String username);
}
package com.example.meconnect.repository;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {


//    ArrayList<Comment> findAllByPostId(long postId);

    Comment save(Comment comment);

    List<Comment> findAllByPostAndIsDeletedFalse(Post post);

    @Transactional
    @Modifying
    @Query(value = "UPDATE comments c SET c.is_deleted = 1 WHERE c.user_name = ?1 AND c.id = ?3 AND c.post_id = ?2", nativeQuery = true)
    void deleteByCommentIdAndPostId(String username, Long postId, Long commentId);
}

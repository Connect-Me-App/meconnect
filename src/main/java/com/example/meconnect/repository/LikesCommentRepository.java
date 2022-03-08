package com.example.meconnect.repository;

import com.example.meconnect.entity.Comment;
import com.example.meconnect.entity.LikesComment;
import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesCommentRepository extends JpaRepository<LikesComment, Long> {

    Optional<LikesComment> findTopByCommentAndUserOrderByIdDesc(Comment comment, User currentUser);
}

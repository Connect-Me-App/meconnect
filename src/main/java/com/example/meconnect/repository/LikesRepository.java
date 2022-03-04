package com.example.meconnect.repository;

import com.example.meconnect.entity.Likes;
import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    //Likes findByPostandUser(Post post, User user);


    Optional<Likes> findTopByPostAndUserOrderByIdDesc(Post post, User currentUser);


    @Query(value =" select case when count(f)> 0 then true else false end from Likes f  where " +
            "  ( f.post = :post AND f.user = :user ) " + " AND ( f.likeType = 1 ) " )
    boolean checkAlreadyLikeOrNot(@Param("post") Post post, @Param("user") User user);

}

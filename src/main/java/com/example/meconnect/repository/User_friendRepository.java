package com.example.meconnect.repository;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.User_friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface User_friendRepository extends JpaRepository<User_friends, Long> {

    User_friends findByUserSenderAndUserReceiver(User userSender, User userReceiver);


    @Modifying
    @Transactional
    @Query("DELETE FROM User_friends f WHERE (f.userSender = :user AND f.userReceiver = :friend) " +
            " OR (f.userSender = :friend AND f.userReceiver = :user)")
    void deletefriend(@Param("user") User user, @Param("friend") User friend);


//    @Query("SELECT f FROM  User_friends f  WHERE (f.userSender = :user or f.userReceiver = :user) " +
//            " AND ( f.isfriend = true)"  )
//          User_friends findFriend(@Param("user") User user);

    @Query("SELECT f FROM  User_friends f  WHERE (f.userSender = :user or f.userReceiver = :user) " +
            " AND ( f.isfriend = true)")
    List<User_friends> findFriend(@Param("user") User user);


    @Query("SELECT f FROM  User_friends f  WHERE ( f.userReceiver = :user) " +
            " AND ( f.isfriend = false)")
    List<User_friends> findNotacceptedRequest(@Param("user") User user);


    @Query("SELECT f FROM  User_friends f  WHERE (f.userSender = :user ) " +
            " AND ( f.isfriend = false)")
    List<User_friends> findNotacceptedRequestofTheUser(@Param("user") User user);


    @Query(" select case when count(f)> 0 then true else false end from User_friends f  where " +
            " ( f.userSender = :user AND f.userReceiver = :friend ) " +
            " OR (f.userSender = :friend AND f.userReceiver = :user) " + " AND ( f.isfriend = true) ")
    boolean checkFriendStatus(@Param("user") User user, @Param("friend") User friend);

}

//userReceiver
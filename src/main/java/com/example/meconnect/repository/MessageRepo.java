package com.example.meconnect.repository;

import com.example.meconnect.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query(value ="SELECT m FROM user_message m " +
            "WHERE ((m.senderUser.id= :firstUserId AND m.targetUser.id = :secondUserId) " +
            "OR  (m.senderUser.id = :secondUserId AND m.targetUser.id = :firstUserId)) " +
            "AND m.is_deleted= 0"+
            "ORDER BY m.sent_at")
         List<Message> findAllMessagesBetweenTwoUsers(
            @Param("firstUserId") Long firstUserId,@Param("secondUserId") Long secondUserId);
               @Query(value = "UPDATE user_message m SET m.is_deleted = 1 WHERE  m.sender_user_id= :sourceId AND m.id = :messageId")
        void deleteMessagesBySenderIdAndMessageId(@Param("sourceId") Long sourceId, @Param("messageId") Long messageId);


       @Transactional
       @Modifying
       @Query(value = "UPDATE user_message m " +
         "SET m.is_read = 1 " +
         "WHERE m.sender_user_id = :sourceId AND m.target_user_id = :targetId" +
         " AND m.is_read = 0")
       void updateStatusFromReadMessages(@Param("sourceId") Long sourceId,@Param("targetId") Long targetId);


}


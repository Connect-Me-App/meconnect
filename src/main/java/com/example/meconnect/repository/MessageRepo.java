package com.example.meconnect.repository;

import java.util.List;

import javax.transaction.Transactional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.meconnect.entity.Message;
@Transactional
@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {
    @Query(value = "" +
            "SELECT m FROM user_message m " +
            "WHERE ((m.sender_user_id =:firstUserId AND m.target_user_id =:secondUserId) " +
            "OR  (m.sender_user_id =:secondUserId AND m.target_user_id =:firstUserId)) " +
            "ORDER BY m.sent_at")
     List<Message> getExistingMessages(@Param("firstUserId")
             long firstUserId, @Param("secondUserId") long secondUserId);
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_message m SET m.is_deleted = 1 WHERE  m.sender_user_id =:sourceId AND m.id =:messageId",nativeQuery = true)
     void deleteBysenderIdAndMessageId(@Param("sourceId") long sourceId, @Param("messageId") long messageId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE user_message  m " +
            "SET m.is_read = 1 " +
            "WHERE m.target_user_id =:targetId AND m.sender_user_id =:sourceId" +
            "    AND m.is_read = 0")
    void updateStatusFromReadMessages(@Param("targetId") long targetId,@Param("sourceId") long sourceId);

}


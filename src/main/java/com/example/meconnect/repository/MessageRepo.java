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
            "SELECT m FROM user_message AS m " +
            "WHERE ((m.source_id = :?1 AND m.target_id = ?2) " +
            "OR  (m.source_id = ?2 AND m.target_id = ?1)) " +
            "ORDER BY m.sent_at",nativeQuery = true)
    public List<Message> getExistingMessages(
             long firstUserId, long secondUserId);

    @Query(value = "UPDATE user_message m SET m.is_deleted = 1 WHERE  m.source_id = ?1 AND m.id = ?2",nativeQuery = true)
    public void deleteBySourceIdAndMessageId(long sourceId,long messageId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE user_message as m " +
            "SET m.is_read = 1 " +
            "WHERE m.target_id =?1 AND m.source_id =?2" +
            "    AND m.is_read = 0",nativeQuery = true)
    void updateStatusFromReadMessages(long targetId,long sourceId);

}


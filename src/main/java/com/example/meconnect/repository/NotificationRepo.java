package com.example.meconnect.repository;

import com.example.meconnect.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {

    Notification save(Notification notification);

    @Transactional
    @Query(value = "SELECT * FROM notification", nativeQuery = true)
    List<Notification> findTop10ByUserNameAndIsReadFalse(String userName);
}

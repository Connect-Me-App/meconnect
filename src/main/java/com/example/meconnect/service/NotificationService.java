package com.example.meconnect.service;

import com.example.meconnect.entity.Notification;
import com.example.meconnect.entity.Post;
import com.example.meconnect.mapper.NotificationMapper;
import com.example.meconnect.model.NotificationResponse;
import com.example.meconnect.repository.NotificationRepo;
import com.example.meconnect.repository.PostRepo;
import com.example.meconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
public class NotificationService {

    @Autowired
    NotificationRepo notificationRepo;

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepo postRepo;

    public List<NotificationResponse> getAllNotifications(String userName) {
        return notificationRepo.findNotification(userName)
                .stream()
                .map(notificationMapper::daoToDto)
                .collect(toList());
    }

    public void insertNotification(String type, String senderUserName, Long postId, Timestamp createdAt) {
        Notification notification = new Notification();
        Post post = postRepo.findByPostIdAndIsDeletedFalse(postId);
        if (post == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post doesn't exist");
        if (Objects.equals(type, "COMMENT_ON_POST")) {
            notification.setUser(post.getUser());
            notification.setText(senderUserName + " has commented on your post.");
            notification.setIsRead(Boolean.FALSE);
            notification.setPostId(postId);
            notification.setType(type);
            notification.setUrl(postId);
            notification.setCreatedBy(senderUserName);
            notification.setUpdatedBy(senderUserName);
            notification.setCreatedAt(post.getCreatedAt());
            notification.setUpdatedAt(post.getUpdatedAt());
            notification.setIsRead(Boolean.FALSE);
        } else if (Objects.equals(type, "LIKE_ON_POST")) {
            notification.setUser(post.getUser());
            notification.setText(senderUserName + " has liked your post.");
            notification.setIsRead(Boolean.FALSE);
            notification.setPostId(postId);
            notification.setType(type);
            notification.setUrl(postId);
            notification.setCreatedBy(senderUserName);
            notification.setUpdatedBy(senderUserName);
            notification.setCreatedAt(post.getCreatedAt());
            notification.setUpdatedAt(post.getUpdatedAt());
            notification.setIsRead(Boolean.FALSE);
        } else if (Objects.equals(type, "LIKE_ON_COMMENT")) {

            notification.setUser(post.getUser());
            notification.setText(senderUserName + " has liked your comment.");
            notification.setIsRead(Boolean.FALSE);
            notification.setPostId(postId);
            notification.setType(type);
            notification.setUrl(postId);
            notification.setCreatedBy(senderUserName);
            notification.setUpdatedBy(senderUserName);
            notification.setCreatedAt(post.getCreatedAt());
            notification.setUpdatedAt(post.getUpdatedAt());
            notification.setIsRead(Boolean.FALSE);
        }
        notificationRepo.save(notification);
    }
}

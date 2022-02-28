package com.example.meconnect.mapper;

import com.example.meconnect.entity.Notification;
import com.example.meconnect.model.NotificationResponse;
import com.example.meconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationMapper {

    @Autowired
    UserRepository userRepository;

    public NotificationResponse daoToDto(Notification notification) {
//        User user = userRepository.findUserByUsername(notification.getUser().getUsername())
        return NotificationResponse.builder()
                .userName(notification.getUser().getUsername())
                .text(notification.getText())
                .createdAt(notification.getCreatedAt())
                .updatedAt(notification.getUpdatedAt())
                .url(notification.getUrl())
                .createdBy(notification.getCreatedBy())
                .updatedBy(notification.getUpdatedBy())
                .type(notification.getType())
                .build();
    }

}

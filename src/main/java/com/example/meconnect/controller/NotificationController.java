package com.example.meconnect.controller;

import com.example.meconnect.model.NotificationResponse;
import com.example.meconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/allNotifications", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return status(HttpStatus.OK).body(notificationService.getAllNotifications(userName));
    }


}

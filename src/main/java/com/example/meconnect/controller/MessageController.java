package com.example.meconnect.controller;

import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/chat")
public class MessageController {
    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @MessageMapping("/newMessages")
    @SendTo("/user/newMessages")
    public ResponseEntity<Void> createMessage(@RequestBody ChatDTO chatDTO) {
        messageService.submitMessageToDB(chatDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @RequestMapping(value = "/all/{from}/{to}", method = RequestMethod.GET)
    public ResponseEntity<List<ChatDTO>> getExistingMessages(@PathVariable Long from, @PathVariable Long to) {
        return status(HttpStatus.OK).body(messageService.getExistingMessages(from, to));
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessageByMessageId(@PathVariable Long messageId) {
        messageService.deleteMessage(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/update/{to}/{from}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStatusFromReadMessages(@PathVariable Long to, @PathVariable Long from) {
        messageService.updateStatus(to, from);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

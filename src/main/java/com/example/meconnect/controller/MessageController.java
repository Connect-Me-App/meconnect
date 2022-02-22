package com.example.meconnect.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.meconnect.mapper.MessageMapper;
import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.service.MessageService;

@RestController
@RequestMapping(path="/api/chat")
public class MessageController {
    @Autowired
    MessageService messageService;




    @RequestMapping(value="/create",method=RequestMethod.POST)
    @MessageMapping("/newMessages")
    @SendTo("/user/newMessages")
    public ResponseEntity<Void> createMessage(@RequestBody ChatDTO chatDTO) {
        messageService.submitMessageToDB(chatDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @RequestMapping(value="/all/{from}/{to}", method=RequestMethod.GET)
    public ResponseEntity<List<ChatDTO>> getExistingMessages(@PathVariable long from,@PathVariable long to) {
        return status(HttpStatus.OK).body(messageService.getExistingMessages(from,to));
    }

    @RequestMapping(value="/{messageId}",method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessageByMessageId(@PathVariable long messageId){
        messageService.deleteMessage(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value="/update/{to}/{from}",method=RequestMethod.PUT)
    public ResponseEntity<Void> updateStatusFromReadMessages(@PathVariable long to,@PathVariable long from){
        messageService.updateStatus(to, from);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

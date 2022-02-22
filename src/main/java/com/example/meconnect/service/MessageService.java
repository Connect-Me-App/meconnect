package com.example.meconnect.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meconnect.entity.Message;
import com.example.meconnect.entity.User;
import com.example.meconnect.mapper.MessageMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.repository.MessageRepo;
import com.example.meconnect.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserRepository userRepository;

    public void submitMessageToDB(ChatDTO chatDTO) {
        Message message=messageMapper.mapChatDTOtoMessage(chatDTO);
        message.setIsDeleted(false);
        message.setIsRead(false);
        message.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
       // message.setCreatedAt(LocalDateTime.now());
       // message.setSentAt(LocalDateTime.now());
        messageRepo.save(message);
    }
    public List<ChatDTO> getExistingMessages(long authorId,long recipientId){
        List<Message> messages=messageRepo.getExistingMessages(authorId, recipientId);
        return messageMapper.mapMessagesToChatDTO(messages);
    }
    public void deleteMessage(long messageId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findUserByUsername(username);
        messageRepo.deleteBySourceIdAndMessageId(user.getId(),messageId);
    }

    public void updateStatus(long to,long from) {
        messageRepo.updateStatusFromReadMessages(to, from);
    }

}

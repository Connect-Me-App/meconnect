package com.example.meconnect.service;

import com.example.meconnect.entity.Message;
import com.example.meconnect.entity.User;
import com.example.meconnect.mapper.MessageMapper;
import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.repository.MessageRepo;
import com.example.meconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserRepository userRepository;

    public void updateStatus(long from, long to) {
        this.messageRepo.updateStatusFromReadMessages(from,to);
    }

    public void submitMessageToDB(ChatDTO chatDTO) {
        Message message = messageMapper.mapChatDTOtoMessage(chatDTO);
        message.setIsDeleted(false);
        message.setIsRead(false);
        message.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        messageRepo.save(message);
    }

    public List<ChatDTO> getExistingMessages(Long senderId, Long targetId) {
        List<Message> messages = messageRepo.findAllByFirstUserIdAndSecondUserId(senderId, targetId);
//        updateStatus(senderId, targetId);
        return messageMapper.mapMessagesToChatDTO(messages);
    }

    public void deleteMessage(long messageId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(username);
        messageRepo.deleteBySenderIdAndMessageId(user.getId(), messageId);
    }



}

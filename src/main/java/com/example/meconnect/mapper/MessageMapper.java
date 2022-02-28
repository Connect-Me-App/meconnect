package com.example.meconnect.mapper;


import com.example.meconnect.entity.Message;
import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.service.Usersservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageMapper {

    private final Usersservice usersservice;

    public List<ChatDTO> mapMessagesToChatDTO(List<Message> messages) {
        List<ChatDTO> chatDTOs = new ArrayList<ChatDTO>();
        for (Message message : messages) {
            ChatDTO chatDTO = ChatDTO.builder()
                    .messageId(message.getMessageId())
                    .senderId(message.getSenderUser().getId())
                    .targetId(message.getTargetUser().getId())
                    .messageText(message.getMessageText())
                    .build();
            chatDTOs.add(chatDTO);

        }
        return chatDTOs;
    }

    public Message mapChatDTOtoMessage(ChatDTO chatDTO) {
        return Message.builder()
                .senderUser(usersservice.getUser(chatDTO.getSenderId()))
                .targetUser(usersservice.getUser(chatDTO.getTargetId()))
                .messageText(chatDTO.getMessageText())
                .build();
    }

}

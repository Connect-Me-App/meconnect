package com.example.meconnect.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.meconnect.entity.Message;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.ChatDTO;
import com.example.meconnect.service.Usersservice;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MessageMapper {

    private final Usersservice usersservice;

    public List<ChatDTO> mapMessagesToChatDTO(List<Message> messages) {
        List<ChatDTO> chatDTOs=new ArrayList<ChatDTO>();
        for(Message message :messages) {
            ChatDTO chatDTO= ChatDTO.builder()
                    .messageId(message.getMessageId())
                    .sourceId(message.getAuthorUser().getId())
                    .targetId(message.getRecipientUser().getId())
                    .messageText(message.getMessageText())
                    .build();
            chatDTOs.add(chatDTO);

        }
        return chatDTOs;
    }
    public Message mapChatDTOtoMessage(ChatDTO chatDTO) {
        return Message.builder()
                .authorUser(usersservice.getUser(chatDTO.getSourceId()))
                .recipientUser(usersservice.getUser(chatDTO.getTargetId()))
                .messageText(chatDTO.getMessageText())
                .build();
    }

}

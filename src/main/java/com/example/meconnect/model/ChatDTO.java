package com.example.meconnect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {
    private Long messageId;
    private Long senderId;
    private Long targetId;
    private String messageText;
    private Timestamp sentAt;
}

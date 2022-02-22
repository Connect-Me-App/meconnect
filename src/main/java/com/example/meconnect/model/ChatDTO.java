package com.example.meconnect.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatDTO {
    private Long messageId;
    private Long sourceId;
    private Long targetId;
    private String messageText;
    private Timestamp sentAt;

    public ChatDTO(Long messageId, Long sourceId, Long targetId, String messageText,
                   Timestamp sentAt) {
        super();
        this.messageId = messageId;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.messageText = messageText;
        this.sentAt=sentAt;

    }
    public Long getMessageId() {
        return messageId;
    }
    public Timestamp getSentAt() {
        return sentAt;
    }
    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public Long getSourceId() {
        return sourceId;
    }
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }
    public Long getTargetId() {
        return targetId;
    }
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}

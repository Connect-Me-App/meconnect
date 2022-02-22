package com.example.meconnect.entity;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="user_message")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long messageId;
    @OneToOne
    @JoinColumn(name="source_id")
    private User authorUser;

    @OneToOne
    @JoinColumn(name="target_id")
    private User recipientUser;

    @NotNull
    @Column(name="message")
    private String messageText;

    @CreationTimestamp
    @Column(name="sent_at")
    private Timestamp sentAt;

    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;

    @CreationTimestamp
    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="is_read")
    private Boolean isRead;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="deleted_by_source")
    private String deletedBySource;

    @Column(name="deleted_by_target")
    private String deletedByTarget;
}


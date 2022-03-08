package com.example.meconnect.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "friendship")
public class User_friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_sender", referencedColumnName = "username")
    private User userSender;

    @ManyToOne
    @JoinColumn(name = "user_receiver", referencedColumnName = "username")
    private User userReceiver;

    @Column(name = "is_friend")
    private boolean isfriend;
}

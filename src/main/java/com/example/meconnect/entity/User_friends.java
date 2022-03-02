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
    Long id;

    @ManyToOne
    @JoinColumn(name = "userSender",referencedColumnName="username")
    User userSender;

    @ManyToOne
    @JoinColumn(name = "userReceiver",referencedColumnName="username")
    User userReceiver;

    @Column(name = "isfriend")
    boolean isfriend;
}

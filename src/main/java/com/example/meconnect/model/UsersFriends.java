package com.example.meconnect.model;


import com.example.meconnect.entity.User;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsersFriends {
    Long id;
    User userSender;
    User userReceiver;
    boolean isfriend;
}

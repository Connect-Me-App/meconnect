package com.example.meconnect.controller;


import com.example.meconnect.entity.User;
import com.example.meconnect.entity.User_friends;
import com.example.meconnect.model.Users;
import com.example.meconnect.model.UsersFriends;
import com.example.meconnect.service.UserFriendshipService;
import com.example.meconnect.service.Usersserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserFriendController {

    @Autowired
    Usersserviceimpl usersserviceimpl;

    @Autowired
    UserFriendshipService userFriendshipService;

    @GetMapping("/sendRequest/{username}")
    public ResponseEntity<?> addFriend(@PathVariable String username) {
        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);
        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        User_friends user_Friendsentity = userFriendshipService.addtofriend(currentUser, username);

        UsersFriends usersFriends = new UsersFriends();
        usersFriends.setUserSender(user_Friendsentity.getUserSender());
        usersFriends.setUserReceiver(user_Friendsentity.getUserReceiver());
        usersFriends.setIsfriend(user_Friendsentity.isIsfriend());

        return new ResponseEntity<>(usersFriends, HttpStatus.OK);
    }


    @GetMapping("/acceptRequest/{username}")
    public ResponseEntity<?> acceptFriend(@PathVariable String username) {

        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);
        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        User_friends user_Friendsentity = userFriendshipService.acceptFriend(currentUser, username);

        UsersFriends usersFriends = new UsersFriends();
        usersFriends.setUserSender(user_Friendsentity.getUserSender());
        usersFriends.setUserReceiver(user_Friendsentity.getUserReceiver());
        usersFriends.setIsfriend(user_Friendsentity.isIsfriend());

        return new ResponseEntity<>(usersFriends, HttpStatus.OK);
    }


    @GetMapping("/deletefriend/{username}")
    public ResponseEntity<?> deleteFriend(@PathVariable String username) {

        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);
        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        userFriendshipService.deletefriendship(currentUser, username);

        return new ResponseEntity<>("user friendship delete succcessfully ", HttpStatus.OK);

    }


    @GetMapping("/getfriend/{username}")
    public ResponseEntity<?> getUserFriend(@PathVariable String username) {
        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);

        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }
        List<Users> users = userFriendshipService.getfriend(username);


        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/NotAcceptrequest/{username}")
    public ResponseEntity<?> notAcceptRequestByTheuser(@PathVariable String username) {

        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);

        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        List<Users> users = userFriendshipService.userNotAccpted(username);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/requestSendbyuser/{username}")
    public ResponseEntity<?> notacceptUserRequest(@PathVariable String username) {

        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);

        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        List<Users> users = userFriendshipService.notAccptedUserRequest(username);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/checkfriend/{username}")
    public ResponseEntity<?> checkFriendStatus(@PathVariable String username) {

        if (username == null) {
            return new ResponseEntity<>("please enter username ", HttpStatus.NOT_FOUND);
        }
        User userfriend = usersserviceimpl.getUserByUserName(username);

        if (userfriend == null) {
            return new ResponseEntity<>("this username not exit ", HttpStatus.NOT_FOUND);
        }

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean checkfriend = userFriendshipService.checkFriendStatus(currentUser, username);

        if (checkfriend == false) {
            return new ResponseEntity<>("this person are not friend of user ", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("this user are friend of each other", HttpStatus.OK);
    }


}

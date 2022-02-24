package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.User_friends;
import com.example.meconnect.model.Users;
import com.example.meconnect.model.UsersFriends;
import com.example.meconnect.repository.User_friendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserFriendshipService {

      @Autowired
      Usersserviceimpl usersserviceimpl;

      @Autowired
      User_friendRepository user_friendRepository;


    public User_friends addtofriend(String currentUsername, String friendusername){

            User currentUser=usersserviceimpl.getUserByUserName(currentUsername);
             User friendUser=usersserviceimpl.getUserByUserName(friendusername);

              User_friends user_friends=new User_friends();
              user_friends.setUserSender(currentUser);
              user_friends.setUserReceiver(friendUser);
              user_friends.setIsfriend(false);

             user_friendRepository.save(user_friends);

              return user_friends;
    }


    public User_friends acceptFriend(String currentUsername,String friendusername){

        User currentUser=usersserviceimpl.getUserByUserName(currentUsername);
        User friendUser=usersserviceimpl.getUserByUserName(friendusername);

//             deletefriendship(currentUsername,friendusername);

        User_friends user_friends=user_friendRepository.findByUserSenderAndUserReceiver(currentUser,friendUser);
              if(user_friends==null){
                  user_friends=user_friendRepository.findByUserSenderAndUserReceiver(friendUser,currentUser);
              }

        user_friends.setIsfriend(true);
        user_friendRepository.save(user_friends);
        return user_friends;
    }

     public void deletefriendship(String currentUsername,String friendusername){

         User currentUser=usersserviceimpl.getUserByUserName(currentUsername);
         User friendUser=usersserviceimpl.getUserByUserName(friendusername);
           user_friendRepository.deletefriend(currentUser,friendUser);

     }


     public List<Users> getfriend(String username){
         User currentUser=usersserviceimpl.getUserByUserName(username);
         List<User_friends> userFriends=user_friendRepository.findFriend(currentUser);
          List<Users> listofFriend=new ArrayList<>();

               for(User_friends userfriendIter : userFriends){

                    if(userfriendIter.getUserSender().getUsername().equals(username)){
                        listofFriend.add(converterUserentity(userfriendIter.getUserReceiver()));
                    }else{
                        listofFriend.add(converterUserentity(userfriendIter.getUserSender()));
                    }

               }

        return listofFriend;
     }


     // the request not accepted by the user
      public List<Users> userNotAccpted(String username){

          User currentUser=usersserviceimpl.getUserByUserName(username);
          List<User_friends> userFriends=user_friendRepository.findNotacceptedRequest(currentUser);
          List<Users> listofNotFriend=new ArrayList<>();

          for(User_friends userfriendIter : userFriends){

              if(userfriendIter.getUserSender().getUsername().equals(username)){
                  listofNotFriend.add(converterUserentity(userfriendIter.getUserReceiver()));
              }else{
                  listofNotFriend.add(converterUserentity(userfriendIter.getUserSender()));
              }

          }

          return listofNotFriend;
      }


      // user friendrequest not accpeted by the another user  user_friendRepository.findNotacceptedRequest(currentUser);
    public List<Users> notAccptedUserRequest(String username){

        User currentUser=usersserviceimpl.getUserByUserName(username);
        List<User_friends> userFriends=user_friendRepository.findNotacceptedRequestofTheUser(currentUser);
        List<Users> listofNotFriend=new ArrayList<>();

        for(User_friends userfriendIter : userFriends){

            if(userfriendIter.getUserSender().getUsername().equals(username)){
                listofNotFriend.add(converterUserentity(userfriendIter.getUserReceiver()));
            }else{
                listofNotFriend.add(converterUserentity(userfriendIter.getUserSender()));
            }

        }

        return listofNotFriend;
    }


     public Users converterUserentity(User user){

         Users users=new Users();
         users.setId(user.getId());
         users.setFirst_name(user.getFirst_name());
         users.setMiddle_name(user.getMiddle_name());
         users.setLast_name(user.getLast_name());
         users.setAddress(user.getAddress());
         users.setEducation(user.getEducation());
         users.setEmail(user.getEmail());
         users.setMobile_no(user.getMobile_no());
         users.setCity(user.getCity());
         users.setUsername(user.getUsername());
         users.setPasswordHash(user.getPasswordHash());
         users.setAboutyou(user.getAboutyou());
         users.setCountry(user.getCountry());
         users.setCity(user.getCity());
         users.setDob(user.getDob());
         users.setIs_active(user.getIs_active());
         users.setIsonline(user.getIsonline());
         users.setProfileurl(user.getProfileurl());

         return users;
     }

}

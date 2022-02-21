package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.VerificationToken;
import com.example.meconnect.model.Users;
import com.example.meconnect.repository.UserRepository;
import com.example.meconnect.repository.verificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//import com.meConnect2.meConnect2.entity.Usersentity;
//import com.meConnect2.meConnect2.model.Users;
//import com.meConnect2.meConnect2.repository.UserRepository;
//import com.meConnect2.meConnect2.service.Usersservice;

@Service
public class Usersserviceimpl implements Usersservice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private verificationTokenRepository verificationTokenRepository;

    @Override
    public User saveUser(Users user) {
        // TODO Auto-generated method stub
        User usersEntity = new User();
        usersEntity.setFirst_name(user.getFirst_name());
        usersEntity.setMiddle_name(user.getMiddle_name());
        usersEntity.setLast_name(user.getLast_name());
        usersEntity.setAddress(user.getAddress());
        usersEntity.setEmail(user.getEmail());
        usersEntity.setMobile_no(user.getMobile_no());
        usersEntity.setCity(user.getCity());
        usersEntity.setEducation(user.getEducation());
       usersEntity.setAboutyou(user.getAboutyou());
        usersEntity.setDob(user.getDob());
        usersEntity.setCountry(user.getCountry());
       //usersEntity.setIs_active(user.getIs_active());
         usersEntity.setIs_active(false);
        usersEntity.setPasswordHash(user.getPasswordHash());
        usersEntity.setUsername(user.getUsername());
        Date registerDate = new Date();
        usersEntity.setRegistered_at(registerDate);
        User user2= userRepository.save(usersEntity);

 //    uncomment when b you test with api same original email
//
        String Token=generateVerificationToken(user2);
        System.out.println("*-------"+Token+"-------------*");

        mailService.sendEmail(user2.getEmail(),"verifiy your account ",
                "Thank you for signing up to meconnect \n" +
                        " please click on the below url to activate your account : \n" +
                        "                \"http://localhost:8080/auccountverification/\" "+ Token);

        return user2;
        //return userRepository.save(usersEntity);
    }


    public String generateVerificationToken(User user) {
        //String token = UUID.randomUUID().toString();
        Random rand=new Random();
        long token=(long)(rand.nextDouble()*1000000);
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(String.valueOf(token));
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return String.valueOf(token);
    }



     public VerificationToken verification(String token){
          VerificationToken verifi=verificationTokenRepository.findByToken(token);
             String username=verifi.getUser().getUsername();
        // System.out.println("*______anshu look line number 81 ____***** "+token+" ****************");
         //String username=SecurityContextHolder.getContext().getAuthentication().getName();

           if(verifi==null){
               return verifi;
           }

           User user =userRepository.findUserByUsername(username);

//
//         System.out.println("*__________***** "+username+" ****************");
//           if(verifi.getUser().equals(username)&&verifi.getToken().equals(token)){
//               System.out.println("******* the username and token verification succcessdully*****" + token);
//               user.setIs_active(true);
//           }
//         System.out.println("********----user is active or not ------"+user.getIs_active()+"  ********");

         if(verifi.getToken().equals(token)){
             System.out.println("******* the username and token verification succcessdully*****" + token);
             user.setIs_active(true);
             verifi.setToken(String.valueOf(99999999));
         }
           userRepository.save(user);

           return verifi;
     }



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User getUser(Long id) {
        //  Usersentity user= userRepository.getById(id);
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }


    @Override
    public User getUserByUserName(String username) {
        User userentity = userRepository.findUserByUsername(username);

        return userentity;
    }


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }


    @Override
    public void updateuser(Users user, Long id) {

        User usersEntity = new User();
        usersEntity.setId(id);
        usersEntity.setFirst_name(user.getFirst_name());
        usersEntity.setMiddle_name(user.getMiddle_name());
        usersEntity.setLast_name(user.getLast_name());
        usersEntity.setAddress(user.getAddress());
        usersEntity.setEmail(user.getEmail());
        usersEntity.setMobile_no(user.getMobile_no());
        usersEntity.setIs_active(user.getIs_active());
        usersEntity.setPasswordHash(user.getPasswordHash());
        usersEntity.setUsername(user.getUsername());
        usersEntity.setCity(user.getCity());
        usersEntity.setEducation(user.getEducation());
        usersEntity.setAboutyou(user.getAboutyou());
        usersEntity.setDob(user.getDob());
        usersEntity.setCountry(user.getCountry());

        userRepository.save(usersEntity);

    }

     public Users  getUserByusername(String username){
        User user=userRepository.findUserByUsername(username);
         if(user==null){
             return null;
         }
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

          return users;
     }


}

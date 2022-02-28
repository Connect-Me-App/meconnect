package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.VerificationToken;
import com.example.meconnect.model.Users;
import com.example.meconnect.repository.UserRepository;
import com.example.meconnect.repository.verificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        usersEntity.setProfileurl(user.getProfileurl());
        usersEntity.setIsonline(user.getIsonline());
        usersEntity.setCountry(user.getCountry());
        //usersEntity.setIs_active(user.getIs_active());
        usersEntity.setIs_active(false);
        usersEntity.setPasswordHash(user.getPasswordHash());
        usersEntity.setUsername(user.getUsername());
        usersEntity.setLast_login(user.getLast_login());
        usersEntity.setRegistered_at(user.getRegistered_at());
        usersEntity.setUpdated_by(user.getUpdated_by());
        usersEntity.setUpdation_dt(user.getUpdation_dt());
        usersEntity.setCreation_dt(user.getCreation_dt());
        usersEntity.setCreated_by(user.getCreated_by());
        Date registerDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd / MM / yy");
        usersEntity.setRegistered_at(registerDate);
        User user2 = userRepository.save(usersEntity);

        //    uncomment when b you test with api same original email
//
        String Token = generateVerificationToken(user2);
        System.out.println("*-------" + Token + "-------------*");

        mailService.sendEmail(user2.getEmail(), "verifiy your account ",
                "Thank you for signing up to meconnect \n" +
                        " please click on the below url to activate your account : \n" +
                        "                \"http://localhost:8080/auccountverification/\" " + Token);

        return user2;
        //return userRepository.save(usersEntity);
    }


    public String generateVerificationToken(User user) {
        //String token = UUID.randomUUID().toString();
        Random rand = new Random();
        long token = (long) (rand.nextDouble() * 1000000);
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(String.valueOf(token));
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return String.valueOf(token);
    }


    public VerificationToken verification(String token) {
        VerificationToken verifi = verificationTokenRepository.findByToken(token);

        // System.out.println("*______anshu look line number 81 ____***** "+token+" ****************");
        //String username=SecurityContextHolder.getContext().getAuthentication().getName();

        if (verifi == null) {
            return verifi;
        }


        String username = verifi.getUser().getUsername();
        User user = userRepository.findUserByUsername(username);

//
//         System.out.println("*__________***** "+username+" ****************");
//           if(verifi.getUser().equals(username)&&verifi.getToken().equals(token)){
//               System.out.println("******* the username and token verification succcessdully*****" + token);
//               user.setIs_active(true);
//           }
//         System.out.println("********----user is active or not ------"+user.getIs_active()+"  ********");

        if (verifi.getToken().equals(token)) {
            System.out.println("******* the username and token verification succcessdully*****" + token);
            user.setIs_active(true);
            verifi.setToken(null);
            verifi.setUser(null);
            verificationTokenRepository.save(verifi);
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
    public void updateuser(Users user, String username) {

        User usersEntity = userRepository.findUserByUsername(username);

        if (user.getUsername() != null) {
            usersEntity.setFirst_name(user.getFirst_name());
        }


        if (user.getMiddle_name() != null) {
            usersEntity.setMiddle_name(user.getMiddle_name());
        }

        if (user.getLast_name() != null) {
            usersEntity.setLast_name(user.getLast_name());
        }

        if (user.getAddress() != null) {
            usersEntity.setAddress(user.getAddress());
        }

        if (user.getEmail() != null) {
            usersEntity.setEmail(user.getEmail());
        }

        if (user.getMobile_no() != null) {
            usersEntity.setMobile_no(user.getMobile_no());
        }

        if (user.getIs_active() != null) {
            usersEntity.setIs_active(user.getIs_active());
        }

        if (user.getPasswordHash() != null) {
            usersEntity.setPasswordHash(user.getPasswordHash());
        }

        if (user.getUsername() != null) {
            usersEntity.setUsername(user.getUsername());
        }

        if (user.getCity() != null) {
            usersEntity.setCity(user.getCity());
        }

        if (user.getEducation() != null) {
            usersEntity.setEducation(user.getEducation());
        }

        if (user.getAboutyou() != null) {
            usersEntity.setAboutyou(user.getAboutyou());
        }

        if (user.getDob() != null) {
            usersEntity.setDob(user.getDob());
        }

        if (user.getCountry() != null) {
            usersEntity.setCountry(user.getCountry());
        }

        if (user.getProfileurl() != null) {
            usersEntity.setProfileurl(user.getProfileurl());
        }

        if (user.getIsonline() != 0) {
            usersEntity.setIsonline(user.getIsonline());
        }

        if (user.getLast_login() != null) {
            usersEntity.setLast_login(user.getLast_login());
        }

        if (user.getRegistered_at() != null) {
            usersEntity.setRegistered_at(user.getRegistered_at());
        }

        if (user.getCreation_dt() != null) {
            usersEntity.setCreation_dt(user.getCreation_dt());
        }

        if (user.getCreated_by() != null) {
            usersEntity.setCreated_by(user.getCreated_by());
        }

        userRepository.save(usersEntity);
    }


    public Users getUserByusername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        Users users = new Users();
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
        users.setLast_login(user.getLast_login());
        users.setRegistered_at(user.getRegistered_at());
        users.setUpdated_by(user.getUpdated_by());
        users.setUpdation_dt(user.getUpdation_dt());
        users.setCreation_dt(user.getCreation_dt());
        users.setCreated_by(user.getCreated_by());

        return users;
    }

    public void deleteToken(String token) {
        verificationTokenRepository.deleteByToken(token);
    }

    public int sendMailForForgetPasssword(String token, User user) {
        String url = "http://localhost:8080/auccountverification/";
        try {
//             mailService.sendEmail(user.getEmail(), "reset your password  ",
//                     " thankyou \n" +
//                             " please click on the below url to activate your account : \n" +
//                                            url + token);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }


    public User updatePassword(User user, String password) {
        user.setPasswordHash(password);
        return userRepository.save(user);
    }


}

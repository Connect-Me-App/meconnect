package com.example.meconnect.controller;


import com.example.meconnect.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mailCode {

     @Autowired
     private MailService mailService;

     @GetMapping("/sendmail")
    public ResponseEntity<?> sendmail(){
         mailService.sendEmail("anshujaiswal_2k18co078@dtu.ac.in","checking mail code is working ",
                 "your are programmer keeping working hard i am proud of you");

        return new ResponseEntity<>("everything is good", HttpStatus.OK);
    }

}

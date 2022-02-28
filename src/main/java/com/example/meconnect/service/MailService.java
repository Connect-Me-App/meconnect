package com.example.meconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mail1;

    public void sendEmail(String toEmail, String subject, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("anshu.jaiswal@peoplestrong.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        try {
            mail1.send(simpleMailMessage);
        } catch (Exception e) {
            System.out.println("there is some error in mail1sending code +line number 20");
            System.out.println("****______________________________________mailerrror____________________*");
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++ email code run succelssfullly++++++++++++++++++++");
    }

}

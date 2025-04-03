package com.etl.emailalert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        System.out.println("📧 Sending email to: " + to);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your.email@gmail.com"); // Replace with your Gmail
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

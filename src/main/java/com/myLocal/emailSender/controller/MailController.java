package com.myLocal.emailSender.controller;

import com.myLocal.emailSender.dto.EmailRequest;
import com.myLocal.emailSender.service.MailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class MailController {
    @Autowired
    MailSenderService mailService;

    @GetMapping("/sendMail")
    public ResponseEntity<String> sendMail(){
        mailService.sendNewMail("meettopalak@gmail.com", "Subject right here", "Body right there!");
        return ResponseEntity.ok("Done");
    }
    @PostMapping("/sendMailWith")
    public ResponseEntity<String> sendMailWith(@RequestBody EmailRequest emailRequest) throws MessagingException, IOException {
        mailService.sendEmailWithAttachment(
                emailRequest.getTo(),
                "Job Application - "+emailRequest.getSubject(),
                "/media/hashtag/HDD/Downloads/emailSender/src/main/resources/static/mail.html",
                "/media/hashtag/HDD/Downloads/emailSender/src/main/resources/static/Pushpraj_Kushwaha_Resume.pdf",
                emailRequest.getPlaceholders()
        );
        return ResponseEntity.ok("Done");
    }
}

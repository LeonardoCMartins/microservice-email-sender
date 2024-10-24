package com.senha.email.controllers;

import com.senha.email.dtos.EmailDto;
import com.senha.email.entitites.Email;
import com.senha.email.services.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/send")
    public ResponseEntity post(@RequestBody EmailDto emailDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(emailDto));
    }




}

package com.senha.email.services;

import com.senha.email.dtos.EmailDto;
import com.senha.email.entitites.Email;
import com.senha.email.repositories.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public EmailDto save (EmailDto emailDto){
        Email email = new Email(emailDto.emailTo(), emailDto.subject(), emailDto.username());
        sendEmail(email);
        repository.save(email);
        return new EmailDto(email);
    }

    @Transactional
    public void sendEmail(Email email) {
        email.setDateSendEmail(LocalDateTime.now());
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setTo(email.getEmailTo());
            helper.setSubject(email.getSubject());

            String htmlContent = generateHtml(email);

            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);

        } catch (MailException | jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    public String generateHtml(Email email) {
        ClassPathResource resource = new ClassPathResource("template-email.html");

        try (InputStream inputStream = resource.getInputStream()) {
            String htmlTemplate = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return htmlTemplate.replace("${username}", email.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}

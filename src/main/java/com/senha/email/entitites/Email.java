package com.senha.email.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String emailTo;
    private String subject;
    private String username;
    private LocalDateTime dateSendEmail;

    public Email(String emailTo, String subject, String username) {
        this.emailTo = emailTo;
        this.subject = subject;
        this.username = username;
    }

}

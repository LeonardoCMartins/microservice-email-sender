package com.senha.email.dtos;

import com.senha.email.entitites.Email;

public record EmailDto(String emailTo, String subject, String username) {
    public EmailDto (Email email){
        this(email.getEmailTo(),email.getSubject(),email.getUsername());
    }
}

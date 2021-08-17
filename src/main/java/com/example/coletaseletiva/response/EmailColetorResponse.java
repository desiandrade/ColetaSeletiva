package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class EmailColetorResponse {

    @Getter private Integer idEmail;
    @Getter private String emailColetor;

    public EmailColetorResponse(EmailColetor emailColetor){
        this.idEmail = emailColetor.getIdEmail();
        this.emailColetor = emailColetor.getEmailColetor();
    }

    public static List<EmailColetorResponse> convert(List<EmailColetor> emails){
        return emails.stream().map(EmailColetorResponse::new).collect(Collectors.toList());
    }
}

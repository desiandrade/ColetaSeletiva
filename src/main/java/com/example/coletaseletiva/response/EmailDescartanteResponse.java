package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.EmailDescartante;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class EmailDescartanteResponse {
     private Integer idEmail;
    private String emailDescartante;

    public EmailDescartanteResponse(EmailDescartante emailDescartante){
        this.idEmail = emailDescartante.getIdEmail();
        this.emailDescartante = emailDescartante.getEmailDescartante();
    }

    public static List<EmailDescartanteResponse> convert(List<EmailDescartante> emails){
        return emails.stream().map(EmailDescartanteResponse::new).collect(Collectors.toList());
    }
}

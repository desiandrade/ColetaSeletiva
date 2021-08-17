package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.EnderecoColetor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class EmailColetorRequest {

    private String emailColetor;
    private Integer idColetor;

    public EmailColetor convert(Coletor coletor){

        EmailColetor emailColetor = new EmailColetor();

        emailColetor.setEmailColetor(this.emailColetor);
        emailColetor.setIdColetor(coletor);

        return emailColetor;

    }

    public EmailColetor convertAtualizar(Integer idEmail, Coletor idColetor){
        return new EmailColetor(idEmail, emailColetor, idColetor, true);
    }


}

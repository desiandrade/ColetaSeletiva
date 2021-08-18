package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.EmailDescartante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDescartanteRequest {

    private String emailDescartante;
    private Integer idDescartante;

    public EmailDescartante convert(Descartante descartante){

        EmailDescartante emailDescartante = new EmailDescartante();

        emailDescartante.setEmailDescartante(this.emailDescartante);
        emailDescartante.setIdDescartante(descartante);

        return emailDescartante;

    }

    public EmailDescartante convertAtualizar(Integer idEmail, Descartante idDescartante){
        return new EmailDescartante(idEmail, emailDescartante, idDescartante, true);
    }

}

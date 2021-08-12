package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ColetorRequest {

    private int idColetor;
    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    public Coletor convert(){

        return new Coletor(idColetor, cpf,nome,sobrenome,dataNascimento);

    }



}

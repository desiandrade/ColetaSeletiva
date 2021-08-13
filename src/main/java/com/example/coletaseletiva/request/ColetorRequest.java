package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
public class ColetorRequest {

    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    public Coletor convert(){

        Coletor coletor = new Coletor();

        coletor.setCpf(this.cpf);
        coletor.setNome(this.nome);
        coletor.setSobrenome(this.sobrenome);
        coletor.setDataNascimento(this.dataNascimento);

        return coletor;

    }

    public Coletor convertAtualizar(Integer idColetor){

        return new Coletor(idColetor,cpf,nome,sobrenome,dataNascimento);
    }



}

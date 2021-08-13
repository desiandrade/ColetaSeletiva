package com.example.coletaseletiva.request;


import com.example.coletaseletiva.entity.Descartante;

import java.sql.Date;

public class DescartanteRequest {

    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    public Descartante convert() {

        Descartante descartante = new Descartante();

        descartante.setCpf(this.cpf);
        descartante.setNome(this.nome);
        descartante.setSobrenome(this.sobrenome);
        descartante.setDataNascimento(this.dataNascimento);

        return descartante;

    }

    public Descartante convertAtualizar(Integer idDescartante) {

        return new Descartante(idDescartante, cpf, nome, sobrenome, dataNascimento);
    }

}
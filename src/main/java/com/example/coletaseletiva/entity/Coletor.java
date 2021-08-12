package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Coletor {

    @Id
    private int idColetor;
    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    //multivalorados? endereço
}

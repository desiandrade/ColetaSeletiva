package com.example.coletaseletiva.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Coletor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idColetor;
    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;


}

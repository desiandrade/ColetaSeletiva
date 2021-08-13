package com.example.coletaseletiva.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Descartante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDescartante;
    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;


}

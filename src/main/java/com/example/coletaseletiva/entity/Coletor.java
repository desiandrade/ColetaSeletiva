package com.example.coletaseletiva.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Coletor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColetor;
    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;


}

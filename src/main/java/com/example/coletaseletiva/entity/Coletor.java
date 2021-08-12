package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Coletor {

    @Id
    @Getter @Setter private int idColetor;
    @Getter @Setter private String cpf;
    @Getter @Setter private String nome;
    @Getter @Setter private String sobrenome;
    @Getter @Setter private Date dataNascimento;

}

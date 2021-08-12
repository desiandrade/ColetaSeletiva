package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnderecoColetor {

    @Id
    private int idEndereco;
    private String nomeRuaAvenida;
    private int numero;
    private String complemento;
    private String bairro;
    private int cep;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn (name = "idColetor", referencedColumnName = "idColetor")
    Coletor idColetor;


}

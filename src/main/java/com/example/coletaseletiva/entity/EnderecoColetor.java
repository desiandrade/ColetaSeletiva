package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EnderecoColetor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEndereco;
    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn (name = "idColetor", referencedColumnName = "idColetor")
    Coletor idColetor;


}

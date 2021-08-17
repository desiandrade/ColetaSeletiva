package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EnderecoDescartante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;
    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private String pontoDeReferencia;
    @ManyToOne
    @JoinColumn (name = "idDescartante" , referencedColumnName = "idDescartante")
    Descartante idDescartante;
    private Boolean ativo;


}

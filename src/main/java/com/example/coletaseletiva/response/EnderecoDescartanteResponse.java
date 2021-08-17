package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.entity.EnderecoDescartante;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EnderecoDescartanteResponse {

    private Integer idEndereco;
    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private Integer idDescartante;

    public EnderecoDescartanteResponse(EnderecoDescartante enderecoDescartante){
        this.idEndereco = enderecoDescartante.getIdEndereco();
        this.nomeRuaAvenida = enderecoDescartante.getNomeRuaAvenida();
        this.numero = enderecoDescartante.getNumero();
        this.complemento = enderecoDescartante.getComplemento();
        this.bairro = enderecoDescartante.getBairro();
        this.cep = enderecoDescartante.getCep();
        this.cidade = enderecoDescartante.getCidade();
        this.estado = enderecoDescartante.getEstado();
        this.idDescartante = enderecoDescartante.getIdDescartante().getIdDescartante();
    }

    public static List<EnderecoDescartanteResponse> convert(List<EnderecoDescartante> enderecos){
        return enderecos.stream().map(EnderecoDescartanteResponse::new).collect(Collectors.toList());
    }
}

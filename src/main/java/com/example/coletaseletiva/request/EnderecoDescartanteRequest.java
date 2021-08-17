package com.example.coletaseletiva.request;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.entity.EnderecoDescartante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDescartanteRequest {

    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private Integer idDescartante;
    private String pontoReferencia;

    public EnderecoDescartante convert( Descartante descartante){

return EnderecoDescartante.builder()
        .nomeRuaAvenida(nomeRuaAvenida)
        .numero(numero)
        .complemento(complemento)
        .bairro(bairro)
        .cep(cep)
        .cidade(cidade)
        .estado(estado)
        .pontoDeReferencia(pontoReferencia)
        .idDescartante(descartante)
        .build();
    }

    public EnderecoDescartante convertAtualizar(Integer idEnderecoDescartante, Descartante idDescartante){

        return new EnderecoDescartante(idEnderecoDescartante,nomeRuaAvenida,numero,complemento,
                bairro,cep,cidade,estado, pontoReferencia, idDescartante, true);
    }



}

package com.example.coletaseletiva.request;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EnderecoColetor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoColetorRequest {

    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private Integer idColetor;

    public EnderecoColetor convert( Coletor coletor){

return EnderecoColetor.builder()
        .nomeRuaAvenida(nomeRuaAvenida)
        .numero(numero)
        .complemento(complemento)
        .bairro(bairro)
        .cep(cep)
        .cidade(cidade)
        .estado(estado)
        .idColetor(coletor)
        .build();
    }

    public EnderecoColetor convertAtualizar(Integer idEnderecoColetor, Coletor idColetor){

        return new EnderecoColetor(idEnderecoColetor,nomeRuaAvenida,numero,complemento,
                bairro,cep,cidade,estado,idColetor, true);
    }



}

package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EnderecoColetor;
import lombok.Getter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EnderecoColetorResponse {

    private Integer idEndereco;
    private String nomeRuaAvenida;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private Integer idColetor;

    public EnderecoColetorResponse(EnderecoColetor enderecoColetor){
        this.idEndereco = enderecoColetor.getIdEndereco();
        this.nomeRuaAvenida = enderecoColetor.getNomeRuaAvenida();
        this.numero = enderecoColetor.getNumero();
        this.complemento = enderecoColetor.getComplemento();
        this.bairro = enderecoColetor.getBairro();
        this.cep = enderecoColetor.getCep();
        this.cidade = enderecoColetor.getCidade();
        this.estado = enderecoColetor.getEstado();
        this.idColetor = enderecoColetor.getIdColetor().getIdColetor();
    }

    public static List<EnderecoColetorResponse> convert(List<EnderecoColetor> enderecos){
        return enderecos.stream().map(EnderecoColetorResponse::new).collect(Collectors.toList());
    }
}

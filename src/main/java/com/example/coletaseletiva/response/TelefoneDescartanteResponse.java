package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.TelefoneColetor;
import com.example.coletaseletiva.entity.TelefoneDescartante;

import java.util.List;
import java.util.stream.Collectors;

public class TelefoneDescartanteResponse {
    private Integer idTelefone;
    private Integer telefoneDescartante;

    public TelefoneDescartanteResponse(TelefoneDescartante telefoneDescartante){
        this.idTelefone = telefoneDescartante.getIdTelefone();
        this.telefoneDescartante = telefoneDescartante.getTelefoneDescartante();
    }

    public static List<TelefoneDescartanteResponse> convert(List<TelefoneDescartante> telefones){
        return telefones.stream().map(TelefoneDescartanteResponse::new).collect(Collectors.toList());
    }
}

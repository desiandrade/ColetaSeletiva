package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.entity.TelefoneColetor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class TelefoneColetorResponse {

    @Getter private Integer idTelefone;
    @Getter private Integer telefoneColetor;

    public TelefoneColetorResponse(TelefoneColetor telefoneColetor){
        this.idTelefone = telefoneColetor.getIdTelefone();
        this.telefoneColetor = telefoneColetor.getTelefoneColetor();
    }

    public static List<TelefoneColetorResponse> convert(List<TelefoneColetor> telefones){
        return telefones.stream().map(TelefoneColetorResponse::new).collect(Collectors.toList());
    }
}

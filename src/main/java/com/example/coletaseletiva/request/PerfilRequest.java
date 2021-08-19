package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.entity.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilRequest {

    private String nome;

    public Perfil convert(){
        return new Perfil(nome);
    }

}

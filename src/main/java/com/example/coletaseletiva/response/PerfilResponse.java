package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Perfil;
import lombok.Getter;
import org.springframework.data.domain.Page;


@Getter
public class PerfilResponse {

    private Integer id;
    private String nome;

    public PerfilResponse(Perfil perfil) {
        this.id = perfil.getId();
        this.nome = perfil.getNome();
    }

    public static Page<PerfilResponse> convert(Page<Perfil> perfis) {
        return perfis.map(PerfilResponse::new);

    }

}

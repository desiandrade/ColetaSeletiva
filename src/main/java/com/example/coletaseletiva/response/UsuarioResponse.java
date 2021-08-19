package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Usuario;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class UsuarioResponse {

    private String email;

    public UsuarioResponse(Usuario usuario) {
        this.email = usuario.getEmail();
    }

    public static Page<UsuarioResponse> convertPage(Page<Usuario> usuarios){
        return usuarios.map(UsuarioResponse::new);
    }

}

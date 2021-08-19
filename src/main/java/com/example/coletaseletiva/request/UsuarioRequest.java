package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    private String email;
    private String password;

    public Usuario convert(){

        String senhaCrypto = new BCryptPasswordEncoder().encode(password);

        return new Usuario(email, senhaCrypto);

    }

}

package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Perfil;
import com.example.coletaseletiva.entity.Usuario;
import com.example.coletaseletiva.repository.PerfilRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioRequest {

    private String email;
    private String password;
    private List<Integer> perfil;

    public Usuario convert(PerfilRepository perfilRepository){

        String senhaCrypto = new BCryptPasswordEncoder().encode(this.password);
        List<Perfil> perfis = new ArrayList<>();
        this.perfil.stream().map(id -> perfis.add(perfilRepository.findById(id).get()));

        return new Usuario(email, senhaCrypto, perfis);

    }

}

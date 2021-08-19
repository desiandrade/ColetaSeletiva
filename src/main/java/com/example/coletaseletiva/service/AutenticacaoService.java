package com.example.coletaseletiva.service;

import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.entity.Usuario;
import com.example.coletaseletiva.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Usuario usuario = usuarioRepository.findByEmail(email)
               .orElseThrow(()-> new UsernameNotFoundException("email não encontrado" + email));

        return usuario;
    }
}

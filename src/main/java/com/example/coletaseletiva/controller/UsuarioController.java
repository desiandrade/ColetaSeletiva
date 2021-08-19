package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Usuario;
import com.example.coletaseletiva.repository.UsuarioRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.request.UsuarioRequest;
import com.example.coletaseletiva.response.ColetorResponse;
import com.example.coletaseletiva.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @GetMapping("/buscarUsuarios")
    public ResponseEntity<Page<UsuarioResponse>> buscarUsuarios(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return ResponseEntity.ok(UsuarioResponse.convertPage(usuarios));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> adicionarUsuario(
            @RequestBody UsuarioRequest usuarioRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRequest.convert();
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }


}

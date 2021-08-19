package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Perfil;
import com.example.coletaseletiva.repository.PerfilRepository;
import com.example.coletaseletiva.request.PerfilRequest;
import com.example.coletaseletiva.response.PerfilResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    @GetMapping
    public ResponseEntity<Page<PerfilResponse>> buscarPerfis(Pageable pageable) {
    Page<Perfil> perfis = perfilRepository.findAll(pageable);
    return ResponseEntity.ok(PerfilResponse.convert(perfis));
    }





    @PostMapping
    public ResponseEntity<PerfilResponse> adicionarPerfil(
            @RequestBody PerfilRequest perfilRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Perfil perfil = perfilRequest.convert();
        perfilRepository.save(perfil);
        URI uri = uriComponentsBuilder.path("/perfis/{id}")
                .buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new PerfilResponse(perfil));
    }


}



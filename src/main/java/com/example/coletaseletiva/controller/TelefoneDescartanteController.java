package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.TelefoneDescartante;
import com.example.coletaseletiva.repository.DescartanteRepository;
import com.example.coletaseletiva.repository.TelefoneDescartanteRepository;
import com.example.coletaseletiva.request.TelefoneDescartanteRequest;
import com.example.coletaseletiva.response.TelefoneDescartanteResponse;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/telefoneDescartante")
public class TelefoneDescartanteController {
    private final TelefoneDescartanteRepository telefoneDescartanteRepository;
    private final DescartanteRepository descartanteRepository;

    @GetMapping
    public ResponseEntity<List<TelefoneDescartanteResponse>> buscarTelefone(){
        List<TelefoneDescartante> telefonesDescartante = telefoneDescartanteRepository.findAll();
        return ResponseEntity.ok().body(TelefoneDescartanteResponse.convert(telefonesDescartante));
    }

    @PostMapping
    public ResponseEntity<TelefoneDescartante> adicionarTelefoneDescartante(
            @RequestBody TelefoneDescartanteRequest telefoneDescartanteRequest,
            UriComponentsBuilder uriComponentsBuilder) throws Exception{
        Descartante descartante = descartanteRepository.findById(telefoneDescartanteRequest.getIdDescartante())
                .orElseThrow(Exception::new);

        TelefoneDescartante telefoneDescartante = telefoneDescartanteRequest.convert(descartante);
        telefoneDescartanteRepository.save(telefoneDescartante);

        URI uri = uriComponentsBuilder.path("/telefoneDescartante/{idTelefone}")
                .buildAndExpand(telefoneDescartante.getIdDescartante()).toUri();
        return ResponseEntity.created(uri).body(telefoneDescartante);
    }

    @PutMapping("/{idTelefone}")
    public ResponseEntity<TelefoneDescartante> atualizar(
            @PathVariable Integer idTelefone,
            @RequestBody TelefoneDescartanteRequest telefoneDescartanteRequest) throws Exception{
        Descartante descartante = descartanteRepository.findById(telefoneDescartanteRequest.getIdDescartante()).
                orElseThrow(Exception::new);
        TelefoneDescartante telefoneDescartante = telefoneDescartanteRequest.convertAtualizar(idTelefone,descartante);
        telefoneDescartanteRepository.save(telefoneDescartante);
        return ResponseEntity.ok(telefoneDescartante);
    }

    @DeleteMapping("/{idTelefone}")
    public ResponseEntity<?> remover(@PathVariable Integer idTelefone){
        telefoneDescartanteRepository.deleteById(idTelefone);
        return ResponseEntity.ok().build();
    }

}

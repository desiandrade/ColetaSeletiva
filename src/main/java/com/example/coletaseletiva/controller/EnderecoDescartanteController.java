package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.entity.EnderecoDescartante;
import com.example.coletaseletiva.repository.*;
import com.example.coletaseletiva.request.EnderecoColetorRequest;
import com.example.coletaseletiva.request.EnderecoDescartanteRequest;
import com.example.coletaseletiva.response.EnderecoColetorResponse;
import com.example.coletaseletiva.response.EnderecoDescartanteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/enderecoDescartante")
@RestController
public class EnderecoDescartanteController {

    private final EnderecoDescartanteRepository enderecoDescartanteRepository;
    private final DescartanteRepository descartanteRepository;

    @GetMapping
    public ResponseEntity<List<EnderecoDescartanteResponse>> buscarEnderecosDescartante() {
        List<EnderecoDescartante> enderecosDescartantes = enderecoDescartanteRepository.findAll();
        return ResponseEntity.ok().body(EnderecoDescartanteResponse.convert(enderecosDescartantes));
    }

    @GetMapping("/buscarNome/{nomeDescartante}")
    public ResponseEntity<List<EnderecoDescartanteResponse>> buscarEnderecosPorDescartante(@PathVariable String nomeDescartante){
        List<EnderecoDescartante> enderecosDescartantes =enderecoDescartanteRepository.findByIdDescartanteNome(nomeDescartante);
        return ResponseEntity.ok().body(EnderecoDescartanteResponse.convert(enderecosDescartantes));
    }

    @PostMapping
    public ResponseEntity<EnderecoDescartanteResponse> adicionarEnderecoDescartante(
            @RequestBody EnderecoDescartanteRequest enderecoDescartanteRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) throws Exception {
        Descartante descartante = descartanteRepository.findById(enderecoDescartanteRequest.getIdDescartante())
                .orElseThrow(Exception::new);
        EnderecoDescartante enderecoDescartante = enderecoDescartanteRequest.convert(descartante);
        enderecoDescartanteRepository.save(enderecoDescartante);
        URI uri = uriComponentsBuilder.path("/enderecoDescartante/{idEnderecoDescartante}")
                .buildAndExpand(enderecoDescartante.getIdEndereco()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDescartanteResponse(enderecoDescartante));
    }

    @PutMapping("/{idEnderecoDescartante}")
    public ResponseEntity<EnderecoDescartanteResponse> atualizar(
            @PathVariable Integer idEnderecoDescartante,
            @RequestBody EnderecoDescartanteRequest enderecoDescartanteRequest
    ) throws Exception {
        Descartante descartante = descartanteRepository.findById(enderecoDescartanteRequest.getIdDescartante())
                .orElseThrow(Exception::new);
        EnderecoDescartante enderecoDescartante = enderecoDescartanteRequest.convertAtualizar(idEnderecoDescartante, descartante);
        enderecoDescartanteRepository.save(enderecoDescartante);
        return ResponseEntity.ok(new EnderecoDescartanteResponse(enderecoDescartante));
    }
    //tratar o erro se ele nao receber o id de coletor

    @DeleteMapping("{idEnderecoDescartante}")
    public ResponseEntity<?> remover(@PathVariable Integer idEnderecoDescartante){
        enderecoDescartanteRepository.deleteById(idEnderecoDescartante);
        return ResponseEntity.ok().build();
    }
}


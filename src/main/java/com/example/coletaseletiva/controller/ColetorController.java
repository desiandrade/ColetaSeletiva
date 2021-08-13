package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.response.ColetorResponse;
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
@RequestMapping("/coletores")
public class ColetorController {

    private final ColetorRepository coletorRepository;

    @GetMapping
    public ResponseEntity<List<ColetorResponse>> buscarColetores(){
        List <Coletor> coletores = coletorRepository.findAll();
        return ResponseEntity.ok().body(ColetorResponse.convert(coletores));
    }

    @PostMapping
    public ResponseEntity<ColetorResponse> adicionarColetor(
            @RequestBody ColetorRequest coletorRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Coletor coletor = coletorRequest.convert();
        coletorRepository.save(coletor);
        URI uri = uriComponentsBuilder.path("/coletores/{idColetor}").buildAndExpand(coletor.getIdColetor()).toUri();
        return ResponseEntity.created(uri).body(new ColetorResponse(coletor));
    }

    @PutMapping("/{idColetor}")
    public ResponseEntity<ColetorResponse> atualizar(
            @PathVariable Integer idColetor,
            @RequestBody ColetorRequest coletorRequest
    ) {
        Coletor coletor = coletorRequest.convertAtualizar(idColetor);
        coletorRepository.save(coletor);
        return ResponseEntity.ok(new ColetorResponse(coletor));
    }

    @DeleteMapping("/{idColetor}")
    public ResponseEntity<?> remover(@PathVariable Integer idColetor){
        coletorRepository.deleteById(idColetor);
        return ResponseEntity.ok().build();
    }





}

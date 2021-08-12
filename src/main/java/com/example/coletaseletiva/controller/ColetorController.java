package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.response.ColetorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Coletor> buscarColetores(){
        List <Coletor> coletores = coletorRepository.findAll();
        return coletores;
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



}

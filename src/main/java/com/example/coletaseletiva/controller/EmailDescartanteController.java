package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.EmailDescartante;
import com.example.coletaseletiva.repository.DescartanteRepository;
import com.example.coletaseletiva.repository.EmailDescartanteRepository;
import com.example.coletaseletiva.request.EmailDescartanteRequest;
import com.example.coletaseletiva.response.EmailDescartanteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/emailDescartante")
public class EmailDescartanteController {


    private final EmailDescartanteRepository emailDescartanteRepository;
    private final DescartanteRepository descartanteRepository;

    @GetMapping
    public ResponseEntity<List<EmailDescartanteResponse>> buscarEmailsDescartante(){
        List<EmailDescartante> emailDescartante = emailDescartanteRepository.findAll();
        return ResponseEntity.ok().body(EmailDescartanteResponse.convert(emailDescartante));
    }

    @PostMapping
    public ResponseEntity<EmailDescartante> adicionarEmailDescartante(
            @RequestBody EmailDescartanteRequest emailDescartanteRequest,
            UriComponentsBuilder uriComponentsBuilder) throws Exception {
        Descartante descartante = descartanteRepository.findById(emailDescartanteRequest
                .getIdDescartante())
                .orElseThrow(Exception::new);

        EmailDescartante emailDescartante = emailDescartanteRequest.convert(descartante);

        emailDescartanteRepository.save(emailDescartante);

        URI uri = uriComponentsBuilder.path("/emailDescartante/{idEmail}")
                .buildAndExpand(emailDescartante.getIdDescartante()).toUri();
        return ResponseEntity.created(uri).body(emailDescartante);
    }

    @PutMapping("{idEmail}")
    public ResponseEntity<EmailDescartante> atualizar(@PathVariable  Integer idEmail,
                                                      @RequestBody EmailDescartanteRequest emailDescartanteRequest
    ) throws Exception {
        Descartante descartante = descartanteRepository.findById(emailDescartanteRequest
                .getIdDescartante())
                .orElseThrow(Exception::new);
        EmailDescartante emailDescartante = emailDescartanteRequest.convertAtualizar(idEmail, descartante);
        emailDescartanteRepository.save(emailDescartante);
        return ResponseEntity.ok(emailDescartante);
    }
    //
    @DeleteMapping("/{idEmail}")
    public ResponseEntity<?> remover(@PathVariable Integer idEmail){
        emailDescartanteRepository.deleteById(idEmail);
        return ResponseEntity.ok().build();
    }


}

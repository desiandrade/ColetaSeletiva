package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.repository.EmailColetorRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.request.EmailColetorRequest;
import com.example.coletaseletiva.response.ColetorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/emailColetor")
public class EmailColetorController {

    private final EmailColetorRepository emailColetorRepository;
    private final ColetorRepository coletorRepository;

@GetMapping
    public ResponseEntity<List<EmailColetor>> buscarEmailsColetor(){
        List<EmailColetor> emailColetor = emailColetorRepository.findAll();
        return ResponseEntity.ok().body(emailColetor);
    }

    @PostMapping
    public ResponseEntity<EmailColetor> adicionarEmailColetor(
            @RequestBody EmailColetorRequest emailColetorRequest,
            UriComponentsBuilder uriComponentsBuilder) throws Exception {
        Coletor coletor = coletorRepository.findById(emailColetorRequest.getIdColetor())
                .orElseThrow(Exception::new);

        EmailColetor emailColetor = emailColetorRequest.convert(coletor);

        emailColetorRepository.save(emailColetor);

        URI uri = uriComponentsBuilder.path("/emailColetor/{idColetor}")
                .buildAndExpand(coletor.getIdColetor()).toUri();
        return ResponseEntity.created(uri).body(emailColetor);
    }

//    @PutMapping("/{idEmail}")
//    public ResponseEntity<EmailColetor> atualizar(
//            @PathVariable Integer idEmail,
//            @RequestBody EmailColetorRequest emailColetorRequest
//    ) {
//        EmailColetor emailColetor = emailColetorRequest.convertAtualizar(idColetor);
//        coletorRepository.save(coletor);
//        return ResponseEntity.ok(new ColetorResponse(coletor));
//    }
//
//    @DeleteMapping("/{idColetor}")
//    public ResponseEntity<?> remover(@PathVariable Integer idColetor){
//        coletorRepository.deleteById(idColetor);
//        return ResponseEntity.ok().build();
//    }

}

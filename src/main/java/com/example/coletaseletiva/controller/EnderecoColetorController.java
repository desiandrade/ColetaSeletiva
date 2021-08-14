package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.repository.EnderecoColetorRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.request.EnderecoColetorRequest;
import com.example.coletaseletiva.response.EnderecoColetorResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
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
@RequestMapping("/enderecoColetor")
@RestController
public class EnderecoColetorController {

    private final EnderecoColetorRepository enderecoColetorRepository;
    private final ColetorRepository coletorRepository;

    @GetMapping
    public ResponseEntity<List<EnderecoColetorResponse>> buscarEnderecosColetores() {
        List<EnderecoColetor> enderecosColetores = enderecoColetorRepository.findAll();
        return ResponseEntity.ok().body(EnderecoColetorResponse.convert(enderecosColetores));
    }

    @PostMapping
    public ResponseEntity<EnderecoColetorResponse> adicionarEnderecoColetor(
            @RequestBody EnderecoColetorRequest enderecoColetorRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) throws Exception {
        Coletor coletor = coletorRepository.findById(enderecoColetorRequest.getIdColetor())
                .orElseThrow(Exception::new);
        EnderecoColetor enderecoColetor = enderecoColetorRequest.convert(coletor);
        enderecoColetorRepository.save(enderecoColetor);
        URI uri = uriComponentsBuilder.path("/enderecoColetor/{idEnderecoColetor}")
                .buildAndExpand(enderecoColetor.getIdEndereco()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoColetorResponse(enderecoColetor));
    }

    @PutMapping("/{idEnderecoColetor}")
    public ResponseEntity<EnderecoColetorResponse> atualizar(
            @PathVariable Integer idEnderecoColetor,
            @RequestBody EnderecoColetorRequest enderecoColetorRequest
    ) throws Exception {
        Coletor coletor = coletorRepository.findById(enderecoColetorRequest.getIdColetor())
                .orElseThrow(Exception::new);
        EnderecoColetor enderecoColetor = enderecoColetorRequest.convertAtualizar(idEnderecoColetor, coletor);
        enderecoColetorRepository.save(enderecoColetor);
        return ResponseEntity.ok(new EnderecoColetorResponse(enderecoColetor));
    }
    //tratar o erro se ele nao receber o id de coletor

    @DeleteMapping("{idEnderecoColetor}")
    public ResponseEntity<?> remover(@PathVariable Integer idEnderecoColetor){
        enderecoColetorRepository.deleteById(idEnderecoColetor);
        return ResponseEntity.ok().build();
    }
}


package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.repository.EmailColetorRepository;
import com.example.coletaseletiva.repository.TelefoneColetorRepository;
import com.example.coletaseletiva.request.EmailColetorRequest;
import com.example.coletaseletiva.request.TelefoneColetorRequest;
import com.example.coletaseletiva.response.TelefoneColetorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/telefoneColetor")
public class TelefoneColetorController {

    private final TelefoneColetorRepository telefoneColetorRepository;
    private final ColetorRepository coletorRepository;

@GetMapping
    public ResponseEntity<List<TelefoneColetorResponse>> buscarTelefoneColetor(){
        List<TelefoneColetor> telefonesColetor = telefoneColetorRepository.findAll();
        return ResponseEntity.ok().body(TelefoneColetorResponse.convert(telefonesColetor));
    }

    @PostMapping
    public ResponseEntity<TelefoneColetor> adicionarTelefoneColetor(
            @RequestBody TelefoneColetorRequest telefoneColetorRequest,
            UriComponentsBuilder uriComponentsBuilder) throws Exception {
        Coletor coletor = coletorRepository.findById(telefoneColetorRequest.getIdColetor())
                .orElseThrow(Exception::new);

        TelefoneColetor telefoneColetor = telefoneColetorRequest.convert(coletor);

        telefoneColetorRepository.save(telefoneColetor);

        URI uri = uriComponentsBuilder.path("/telefoneColetor/{idTelefone}")
                .buildAndExpand(telefoneColetor.getIdColetor()).toUri();
        return ResponseEntity.created(uri).body(telefoneColetor);
    }

    @PutMapping("{idTelefone}")
    public ResponseEntity<TelefoneColetor> atualizar(@PathVariable  Integer idTelefone,
            @RequestBody TelefoneColetorRequest telefoneColetorRequest
    ) throws Exception {
        Coletor coletor = coletorRepository.findById(telefoneColetorRequest.getIdColetor())
                .orElseThrow(Exception::new);
        TelefoneColetor telefoneColetor = telefoneColetorRequest.convertAtualizar(idTelefone, coletor);
        telefoneColetorRepository.save(telefoneColetor);
        return ResponseEntity.ok(telefoneColetor);
    }

    @DeleteMapping("/{idTelefone}")
    public ResponseEntity<?> remover(@PathVariable Integer idTelefone){
        telefoneColetorRepository.deleteById(idTelefone);
        return ResponseEntity.ok().build();
    }

}

package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.response.ColetorResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> buscarColetores(){
       try { List <Coletor> coletores = coletorRepository.findAll();
        if(coletores.size() > 0) {
            return ResponseEntity.ok().body(ColetorResponse.convert(coletores));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Coletor encontrado");
        } } catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível conectar ao banco de dados");
       }
    }

    @GetMapping("/buscarNome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
            List<Coletor> coletores = coletorRepository.findByNome(nome);
            if (coletores.size() > 0 ) {
                return ResponseEntity.ok().body(ColetorResponse.convert(coletores));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nome não encontrado. Nome informado: " + nome);
            }
    }

    @GetMapping("/buscarPorPagina")
    public ResponseEntity<Page<ColetorResponse>> buscarPorPagina(Pageable pageable){
        Page<Coletor> coletores = coletorRepository.findAll(pageable);
        return ResponseEntity.ok(ColetorResponse.convertPage(coletores));
    }

    @PostMapping
    public ResponseEntity<?> adicionarColetor(
            @RequestBody ColetorRequest coletorRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Coletor coletor = coletorRequest.convert();
        try {
        coletorRepository.save(coletor);
        URI uri = uriComponentsBuilder.path("/coletores/{idColetor}")
                .buildAndExpand(coletor.getIdColetor()).toUri();
        return ResponseEntity.created(uri).body(new ColetorResponse(coletor)); }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível salvar o dado");
        }
    }

    @PutMapping("/{idColetor}")
    public ResponseEntity<?> atualizar(
            @PathVariable Integer idColetor,
            @RequestBody ColetorRequest coletorRequest
    ) { List <Coletor>listaColetores = coletorRepository.findAll();
        if (listaColetores.stream().anyMatch(c -> c.getIdColetor().equals(idColetor))) {
        try {Coletor coletor = coletorRequest.convertAtualizar(idColetor);
        coletorRepository.save(coletor);
        return ResponseEntity.ok(new ColetorResponse(coletor));} catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possivel atualizar o dado");
        }  } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coletor não encontrado. Id informado: " + idColetor);
    }
    }

    @DeleteMapping("/{idColetor}")
    public ResponseEntity<?> remover(@PathVariable Integer idColetor){
        try { coletorRepository.deleteById(idColetor);
        return ResponseEntity.ok().body("Coletor de id:" + idColetor + " removido com sucesso"); }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coletor não encontrado. Id informado: " + idColetor);
        }
    }
}
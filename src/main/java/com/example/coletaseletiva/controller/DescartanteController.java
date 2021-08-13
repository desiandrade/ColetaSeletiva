package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.repository.DescartanteRepository;
import com.example.coletaseletiva.request.DescartanteRequest;
import com.example.coletaseletiva.response.DescartanteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/descartantes")
public class DescartanteController {

    private final DescartanteRepository descartanteRepository;

    @GetMapping
    public ResponseEntity<List<DescartanteResponse>> buscarDescartantes() {
        List<Descartante> descartantes = descartanteRepository.findAll();
        return ResponseEntity.ok().body(DescartanteResponse.convert(descartantes));
    }

    @PostMapping
    public ResponseEntity<DescartanteResponse> adicionarDescartante(
            @RequestBody DescartanteRequest descartanteRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        Descartante descartante = descartanteRequest.convert();
        descartanteRepository.save(descartante);
        URI uri = uriComponentsBuilder.path("/descartantes/{idDescartantes}")
                .buildAndExpand(descartante.getIdDescartante()).toUri();
        return ResponseEntity.created(uri).body(new DescartanteResponse(descartante));
    }

    @PutMapping("/{idDescartante}")
    public ResponseEntity<DescartanteResponse> atualizar(
            @PathVariable Integer idDescartante,
            @RequestBody DescartanteRequest descartanteRequest
    ) {
        Descartante descartante = descartanteRequest.convertAtualizar(idDescartante);
        descartanteRepository.save(descartante);
        return ResponseEntity.ok(new DescartanteResponse(descartante));
    }

    @DeleteMapping("/{idDescartante}")
    public ResponseEntity<?> remover(@PathVariable Integer idDescartante) {
        descartanteRepository.deleteById(idDescartante);
        return ResponseEntity.ok().build();
    }
}

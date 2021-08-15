package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.repository.ColetorRepository;
import com.example.coletaseletiva.repository.DescartanteRepository;
import com.example.coletaseletiva.repository.DescarteRepository;
import com.example.coletaseletiva.repository.MaterialRepository;
import com.example.coletaseletiva.request.ColetorRequest;
import com.example.coletaseletiva.request.DescarteRequest;
import com.example.coletaseletiva.response.ColetorResponse;
import com.example.coletaseletiva.response.DescarteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/descartes")
public class DescarteController {

    private final DescarteRepository descarteRepository;
    private final ColetorRepository coletorRepository;
    private final DescartanteRepository descartanteRepository;
    private final MaterialRepository materialRepository;

    @GetMapping
    public ResponseEntity<List<DescarteResponse>> buscarDescartes(){
        List <Descarte> descartes = descarteRepository.findAll();
        return ResponseEntity.ok().body(DescarteResponse.convert(descartes));
    }

    @PostMapping
    public ResponseEntity<DescarteResponse> adicionarDescarte(
            @RequestBody DescarteRequest descarteRequest,
            UriComponentsBuilder uriComponentsBuilder) throws Exception {

     //   Coletor coletor = coletorRepository.findById(descarteRequest.getIdColetor())
     //           .orElseThrow(()-> new Exception());

        Descartante descartante = descartanteRepository.findById(descarteRequest.getIdDescartante())
                .orElseThrow(()-> new Exception());

        Material material = materialRepository.findById(descarteRequest.getIdMaterial())
                .orElseThrow(()-> new Exception());


//        Optional<Descartante> descartante = descartanteRepository.findById(descarteRequest.getIdDescartante());
//        descartante.ifPresent(descarte1::setIdDescartante);

        Descarte descarte = descarteRequest.convert(descartante, material);
        descarteRepository.save(descarte);
        URI uri = uriComponentsBuilder.path("/coletores/{idDescarte}").buildAndExpand(descarte.getIdDescarte()).toUri();
        return ResponseEntity.created(uri).body(new DescarteResponse(descarte));
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

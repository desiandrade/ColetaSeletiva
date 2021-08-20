package com.example.coletaseletiva.controller;


import com.example.coletaseletiva.entity.*;
import com.example.coletaseletiva.repository.*;
import com.example.coletaseletiva.request.DescartePutColetorRequest;
import com.example.coletaseletiva.request.DescartePutDescartanteRequest;
import com.example.coletaseletiva.request.DescarteRequest;
import com.example.coletaseletiva.response.DescarteColetorProjecao;
import com.example.coletaseletiva.response.DescarteDescartanteProjecao;
import com.example.coletaseletiva.response.DescarteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/descartes")
public class DescarteController {

    private final DescarteRepository descarteRepository;
    private final ColetorRepository coletorRepository;
    private final DescartanteRepository descartanteRepository;
    private final MaterialRepository materialRepository;
    private final EnderecoDescartanteRepository enderecoDescartanteRepository;



    @GetMapping
    public ResponseEntity<List<DescarteResponse>> buscarDescartes(){
        List <Descarte> descartes = descarteRepository.findAll();
        return ResponseEntity.ok().body(DescarteResponse.convert(descartes));
    }


    @GetMapping("/pesquisaLivreDoColetor")
    public ResponseEntity<List<DescarteColetorProjecao>> findDisponiveis() {
        return ResponseEntity.ok().body(descarteRepository.findDisponiveis());
    }

    @GetMapping("/pesquisaDoDescartante/{idDescartante}")
    public ResponseEntity<List<DescarteDescartanteProjecao>> findDescartesAssociados(@PathVariable Integer idDescartante) {
        return ResponseEntity.ok().body(descarteRepository.findDescartesAssociados(idDescartante));
    }

    @GetMapping("/descarteEndereco/{idDescarte}")
    public ResponseEntity<EnderecoDescartante> findByIdDescarte(@PathVariable Integer idDescarte) throws Exception {

        Descarte descarte = descarteRepository.findById(idDescarte)
                .orElseThrow(Exception::new);

        EnderecoDescartante enderecoDescartante = enderecoDescartanteRepository
                .findByIdDescarte(descarte.getIdEnderecoDescartante());

        return ResponseEntity.ok().body(enderecoDescartante);
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

    @PutMapping("/coletor/{idDescarte}")
    //TODO Tratar os responses um para cada put
    public ResponseEntity<DescarteResponse> atualizarDescartePeloColetor(
            @PathVariable Integer idDescarte,
            @RequestBody DescartePutColetorRequest descartePutColetorRequest
    ) throws Exception {

        Descarte descarte = descarteRepository.findById(descartePutColetorRequest.getIdDescarte())
                .orElseThrow(Exception::new);

        Coletor coletor = coletorRepository.findById(descartePutColetorRequest.getIdColetor())
                   .orElse(null);

        Descarte descarteAtualizado = descartePutColetorRequest.convert(descarte, coletor);
        descarteRepository.save(descarteAtualizado);
        return ResponseEntity.ok(new DescarteResponse(descarteAtualizado));
    }

    @PutMapping("/descartante/{idDescarte}")
    //TODO Tratar os responses um para cada put
    public ResponseEntity<DescarteResponse> atualizarDescartePeloDescartante(
            @PathVariable Integer idDescarte,
            @RequestBody DescartePutDescartanteRequest descartePutDescartanteRequest
    ) throws Exception {

        Descarte descarte = descarteRepository.findById(descartePutDescartanteRequest.getIdDescarte())
                .orElseThrow(Exception::new);

        Coletor coletor = coletorRepository.findById(descartePutDescartanteRequest.getIdColetor())
                .orElse(null);

        Material material = materialRepository.findById(descartePutDescartanteRequest.getIdMaterial())
                .orElse(null);

        //TODO Um descartante só pode cancelar um descarte se não tiver coletor associado

        Descarte descarteAtualizado = descartePutDescartanteRequest.convert(descarte, coletor, material);
        descarteRepository.save(descarteAtualizado);
        return ResponseEntity.ok(new DescarteResponse(descarteAtualizado));
    }



    @DeleteMapping("/{idDescarte}")
    public ResponseEntity<?> remover(@PathVariable Integer idDescarte) throws Exception {

        Descarte descarte = descarteRepository.findById(idDescarte)
                .orElseThrow(()-> new Exception());
        descarte.setAtivo(false);
        descarteRepository.save(descarte);

        return ResponseEntity.ok().build();
    }


}

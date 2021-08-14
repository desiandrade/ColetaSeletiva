package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.repository.MaterialRepository;
import com.example.coletaseletiva.request.MaterialRequest;
import com.example.coletaseletiva.response.MaterialResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/material")
public class MaterialController {
    private final MaterialRepository materialRepository;

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> buscarMaterials(){
        List<Material> materials = materialRepository.findAll();
        return ResponseEntity.ok().body(MaterialResponse.convert(materials));
    }

    @PostMapping
    public ResponseEntity<MaterialResponse> adicionarMaterial(
            @RequestBody MaterialRequest materialRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        Material material = materialRequest.convert();
        materialRepository.save(material);
        URI uri = uriComponentsBuilder.path("/material/{idMaterial}").
                buildAndExpand(material.getIdMaterial()).toUri();
        return ResponseEntity.created(uri).body(new MaterialResponse(material));
    }

    @PutMapping("/{idMaterial}")
    public ResponseEntity<MaterialResponse> atualizar(
            @PathVariable int idMaterial,
            @RequestBody MaterialRequest materialRequest){
        Material material = materialRequest.convertAtualizar(idMaterial);
        materialRepository.save(material);
        return ResponseEntity.ok(new MaterialResponse(material));
    }

    @DeleteMapping("/{idMaterial}")
    public ResponseEntity<?>remover(@PathVariable int idMaterial){
        materialRepository.deleteById(idMaterial);
        return ResponseEntity.ok().build();
    }


}

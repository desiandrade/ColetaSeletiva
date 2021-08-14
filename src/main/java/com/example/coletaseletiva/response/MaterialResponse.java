package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Material;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class MaterialResponse {

    @Getter private int idMaterial;
    @Getter private String nomeMaterial;

    public MaterialResponse(Material material){
        this.idMaterial = material.getIdMaterial();
        this.nomeMaterial = material.getNomeMaterial();
    }

    public static List<MaterialResponse> convert(List<Material> materiais){
        return materiais.stream().map(MaterialResponse::new).collect(Collectors.toList());
    }
}

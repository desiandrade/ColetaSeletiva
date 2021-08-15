package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MaterialRequest {

    private String nomeMaterial;

    public Material convert(){
        Material material = new Material();
        material.setNomeMaterial(this.nomeMaterial);
        return material;
    }

    public Material convertAtualizar(int idMaterial){
        return new Material(idMaterial, nomeMaterial);
    }

}

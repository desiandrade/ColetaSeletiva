package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.Material;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DescarteResponse {


    private Integer idDescarte;
    private Date   dataDescarte;
    private String obsDescartante;
    private Integer pesoEmKg;
    private Integer volumeEmLitros;
    private Integer idColetor;
    private Integer idDescartante;
    private String nomeMaterial;


    public DescarteResponse(Descarte descarte){
        this.idDescarte = descarte.getIdDescarte();
        this.dataDescarte = descarte.getDataDescarte();
        this.obsDescartante = descarte.getObsDescartante();
        this.pesoEmKg = descarte.getPesoEmKg();
        this.volumeEmLitros = descarte.getVolumeEmLitros();
//        this.idColetor = descarte.getIdColetor().getIdColetor();
        this.idDescartante = descarte.getIdDescartante().getIdDescartante();
        this.nomeMaterial = descarte.getIdMaterial().getNomeMaterial();
    }

    public static List<DescarteResponse> convert(List<Descarte> descartes){
        return descartes.stream().map(DescarteResponse::new).collect(Collectors.toList());
    }
}

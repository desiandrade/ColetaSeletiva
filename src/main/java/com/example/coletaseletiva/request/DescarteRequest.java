package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.Material;
import com.example.coletaseletiva.repository.ColetorRepository;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class DescarteRequest {

    private Date dataDescarte;
    private Date dataColeta;
    private Date registroAdicionadoEm;
    private Date registroModificadoEm;
    private String obsColetor;
    private String obsDescartante;
    private Integer pesoEmKg;
    private Integer volumeEmLitros;
   // private Integer idColetor;
    private Integer idDescartante;
    private Integer idMaterial;

    public Descarte convert(Descartante descartante, Material material) {


        Descarte descarte = new Descarte();
        //Coletor coletor = new Coletor();
        descarte.setDataColeta(this.dataColeta);
        descarte.setRegistroAdicionadoEm(this.registroAdicionadoEm);
        descarte.setRegistroModificadoEm(this.registroModificadoEm);
        descarte.setObsColetor(this.obsColetor);
        descarte.setObsDescartante(this.obsDescartante);
        descarte.setPesoEmKg(this.pesoEmKg);
        descarte.setVolumeEmLitros(this.volumeEmLitros);
        //descarte.setIdColetor(coletor);
        descarte.setIdDescartante(descartante);
        descarte.setIdMaterial(material);

        return descarte;

    }
}
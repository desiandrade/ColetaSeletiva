package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class DescartePutColetorRequest {

    private Integer idDescarte;
    //private Date dataDescarte;
    private Date dataColeta;
    //private Date registroAdicionadoEm;
    //private Date registroModificadoEm;
    private String obsColetor;
    //private String obsDescartante;
    //private Integer pesoEmKg;
    //private Integer volumeEmLitros;
    private Integer idColetor;
    //private Integer idDescartante;
    //private Integer idMaterial;

    public Descarte convert(Descarte descarte, Coletor coletor) {


        descarte.setDataColeta(this.dataColeta);
        //descarte.setRegistroAdicionadoEm(Date.valueOf(LocalDate.now()));
        descarte.setRegistroModificadoEm(Date.valueOf(LocalDate.now()));
        descarte.setObsColetor(this.obsColetor);
        //descarte.setObsDescartante(this.obsDescartante);
        //descarte.setPesoEmKg(this.pesoEmKg);
        //descarte.setVolumeEmLitros(this.volumeEmLitros);

        descarte.setIdColetor(coletor);

        //descarte.setIdDescartante(descartante);
        //descarte.setIdMaterial(material);
        //descarte.setAtivo(true);

        return descarte;

    }
}
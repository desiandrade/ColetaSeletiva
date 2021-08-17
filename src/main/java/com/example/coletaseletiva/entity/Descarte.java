package com.example.coletaseletiva.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Descarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDescarte;
    private Date dataDescarte;
    private Date dataColeta;
    private Date registroAdicionadoEm;
    private Date registroModificadoEm;
    private String obsColetor;
    private String obsDescartante;
    private Integer pesoEmKg;
    private Integer volumeEmLitros;
    private Boolean ativo;

    @OneToOne
    @JoinColumn (name = "idColetor", referencedColumnName = "idColetor")
    Coletor idColetor;

    @OneToOne
    @JoinColumn (name = "idDescartante", referencedColumnName = "idDescartante")
    @NotNull
    Descartante idDescartante;

    @OneToOne
    @JoinColumn (name = "idMaterial", referencedColumnName = "idMaterial")
    @NotNull
    Material idMaterial;




}

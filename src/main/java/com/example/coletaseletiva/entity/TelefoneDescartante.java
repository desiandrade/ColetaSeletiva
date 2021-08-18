package com.example.coletaseletiva.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class TelefoneDescartante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefone;
    private Integer TelefoneDescartante;

    @ManyToOne
    @JoinColumn(name="idDescartante", referencedColumnName = "idDescartante")
    Descartante idDescartante;
    private Boolean ativo;
}

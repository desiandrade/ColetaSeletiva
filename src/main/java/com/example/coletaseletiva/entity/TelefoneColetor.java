package com.example.coletaseletiva.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TelefoneColetor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefone;
    private Integer TelefoneColetor;

    @ManyToOne
    @JoinColumn (name = "idColetor", referencedColumnName = "idColetor")
    Coletor idColetor;

}

package com.example.coletaseletiva.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmailColetor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmail;
    private String emailColetor;

    @ManyToOne
    @JoinColumn (name = "idColetor", referencedColumnName = "idColetor")
    Coletor idColetor;

}

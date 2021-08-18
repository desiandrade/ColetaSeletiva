package com.example.coletaseletiva.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmailDescartante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmail;
    private String emailDescartante;
    @ManyToOne
    @JoinColumn (name = "idDescartante", referencedColumnName = "idDescartante")
    Descartante idDescartante;
    private Boolean ativo;
}

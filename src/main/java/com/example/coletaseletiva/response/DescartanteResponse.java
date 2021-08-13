package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descartante;
import lombok.Getter;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
@Getter
public class DescartanteResponse {



        private Integer idDescartante;
        private String cpf;
        private String nome;
        private String sobrenome;
        private Date dataNascimento;

        public DescartanteResponse(Descartante descartante){
            this.idDescartante = descartante.getIdDescartante();
            this.cpf = descartante.getCpf();
            this.nome = descartante.getNome();
            this.sobrenome = descartante.getSobrenome();
            this.dataNascimento = descartante.getDataNascimento();
        }

    public static List<DescartanteResponse> convert(List<Descartante> descartantes){
        return descartantes.stream().map(DescartanteResponse::new).collect(Collectors.toList()); }
}

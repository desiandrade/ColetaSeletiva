package com.example.coletaseletiva.response;

import com.example.coletaseletiva.entity.Coletor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ColetorResponse {


    @Getter  private Integer idColetor;
    @Getter  private String cpf;
    @Getter  private String nome;
    @Getter  private String sobrenome;
    @Getter  private LocalDate dataNascimento;

    public ColetorResponse(Coletor coletor){
        this.idColetor = coletor.getIdColetor();
        this.cpf = coletor.getCpf();
        this.nome = coletor.getNome();
        this.sobrenome = coletor.getSobrenome();
        this.dataNascimento = coletor.getDataNascimento();
    }

    public static List<ColetorResponse> convert(List<Coletor> coletores){
        return coletores.stream().map(ColetorResponse::new).collect(Collectors.toList());
    }

    public static Page<ColetorResponse> convertPage(Page<Coletor> coletores){
        return coletores.map(ColetorResponse::new);
    }
}

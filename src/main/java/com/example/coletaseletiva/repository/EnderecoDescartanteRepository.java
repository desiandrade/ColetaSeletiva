package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.entity.EnderecoDescartante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoDescartanteRepository extends JpaRepository <EnderecoDescartante, Integer> {

    @Query(value = "select ed.* from descarte d inner join descartante dt on d.id_descartante = dt.id_descartante inner join endereco_descartante ed on ed.id_endereco = d.id_endereco_descartante where id_descarte = ?1", nativeQuery = true)
    EnderecoDescartante findByIdDescarte(Integer idDescarte);

    List <EnderecoDescartante> findByIdDescartanteNome(String nome);
}

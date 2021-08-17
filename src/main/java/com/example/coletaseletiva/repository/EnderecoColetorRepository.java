package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EnderecoColetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoColetorRepository extends JpaRepository <EnderecoColetor, Integer> {

    List <EnderecoColetor> findByIdColetorNome(String nome);
}

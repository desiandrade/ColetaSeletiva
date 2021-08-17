package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetorRepository extends JpaRepository <Coletor, Integer> {


    List<Coletor> findByNome(String nome);
}

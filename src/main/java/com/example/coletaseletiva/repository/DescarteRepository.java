package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.EnderecoDescartante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescarteRepository extends JpaRepository <Descarte, Integer> {


}

package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.Descarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescarteRepository extends JpaRepository <Descarte, Integer> {
}

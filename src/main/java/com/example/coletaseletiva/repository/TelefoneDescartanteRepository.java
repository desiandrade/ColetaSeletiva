package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.TelefoneDescartante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneDescartanteRepository extends JpaRepository<TelefoneDescartante, Integer> {
}

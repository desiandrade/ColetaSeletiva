package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EmailDescartante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDescartanteRepository extends JpaRepository<EmailDescartante, Integer> {

}

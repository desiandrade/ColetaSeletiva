package com.example.coletaseletiva.repository;



import com.example.coletaseletiva.entity.Descartante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescartanteRepository extends JpaRepository<Descartante, Integer> {
}

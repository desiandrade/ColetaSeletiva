package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetorRepository extends JpaRepository <Coletor, Integer> {
}

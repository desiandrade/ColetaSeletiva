package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EnderecoColetor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoColetorRepository extends JpaRepository <EnderecoColetor, Integer> {
}
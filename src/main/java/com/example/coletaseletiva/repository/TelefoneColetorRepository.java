package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EnderecoColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneColetorRepository extends JpaRepository <TelefoneColetor, Integer> {
}

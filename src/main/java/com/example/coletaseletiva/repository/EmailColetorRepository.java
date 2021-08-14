package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailColetorRepository extends JpaRepository <EmailColetor, Integer> {
}

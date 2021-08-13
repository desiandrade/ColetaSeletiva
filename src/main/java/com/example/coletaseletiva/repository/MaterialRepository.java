package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository <Material, Integer> {
}

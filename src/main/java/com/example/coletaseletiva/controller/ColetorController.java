package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.repository.ColetorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/coletores")
public class ColetorController {

    private final ColetorRepository coletorRepository;

    @GetMapping
    public List<Coletor> buscarColetores(){
        List <Coletor> coletores = coletorRepository.findAll();
        return coletores;
    }



}

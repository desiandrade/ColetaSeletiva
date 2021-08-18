package com.example.coletaseletiva.controller;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.repository.ColetorRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ColetorControllerTest {

    @Autowired
    private ColetorRepository coletorRepository;

    @Test
    void findColetor(){
        Coletor coletor = Coletor.builder().cpf("123456").nome("Desirée").sobrenome("Andrade").build();
        coletorRepository.save(coletor);
        List<Coletor> coletores = coletorRepository.findAll();
        assertFalse(coletores.isEmpty());
    }

    @Test
    void saveColetor(){
        Coletor coletor = Coletor.builder().cpf("25465").nome("Joao").sobrenome("Faria").build();
        Coletor coletor1 = coletorRepository.save(coletor);
        assertEquals(coletor1.getNome(), "Joao");
    }
}

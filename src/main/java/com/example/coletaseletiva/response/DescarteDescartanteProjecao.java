package com.example.coletaseletiva.response;

import java.time.LocalDateTime;

public interface DescarteDescartanteProjecao {

    Integer getIdDescarte();
    LocalDateTime getDataDescarte();
    String getObsDescartante();
    String getNomeMaterial();
    Integer getPesoEmKg();
    Integer getVolumeEmLitros();
    LocalDateTime getRegistroAdicionadoEm();
    String getNomeRuaAvenida();
    Integer getNumero();
    String getComplemento();
    String getBairro();
    Integer getCep();
    String getCidade();
    String getEstado();
    String getNome();
    String getSobreNomeColetor();
}

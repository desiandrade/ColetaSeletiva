package com.example.coletaseletiva.response;

import java.sql.Date;
import java.time.LocalDateTime;

public interface DescarteColetorProjecao {

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

}

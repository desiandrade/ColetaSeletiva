package com.example.coletaseletiva.response;

import java.sql.Date;
import java.time.LocalDateTime;

public interface DescarteDescartanteProjecao {

    Integer getIdDescarte();
    Date getDataDescarte();
    String getObsDescartante();
    String getNomeMaterial();
    Integer getPesoEmKg();
    Integer getVolumeEmLitros();
    Date getRegistroAdicionadoEm();
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

package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Coletor;
import com.example.coletaseletiva.entity.EmailColetor;
import com.example.coletaseletiva.entity.TelefoneColetor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TelefoneColetorRequest {

    private Integer telefoneColetor;
    private Integer idColetor;

    public TelefoneColetor convert(Coletor coletor){

        TelefoneColetor telefoneColetor = new TelefoneColetor();

        telefoneColetor.setTelefoneColetor(this.telefoneColetor);
        telefoneColetor.setIdColetor(coletor);

        return telefoneColetor;

    }

    public TelefoneColetor convertAtualizar(Integer idTelefone, Coletor idColetor){
        return new TelefoneColetor(idTelefone, this.telefoneColetor, idColetor);
    }


}

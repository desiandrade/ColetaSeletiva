package com.example.coletaseletiva.request;

import com.example.coletaseletiva.entity.Descartante;
import com.example.coletaseletiva.entity.TelefoneDescartante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TelefoneDescartanteRequest {
    public Integer telefoneDescartante;
    public Integer idDescartante;

    public TelefoneDescartante convert(Descartante descartante){
        TelefoneDescartante telefoneDescartante = new TelefoneDescartante();
        telefoneDescartante.setTelefoneDescartante(this.telefoneDescartante);
        telefoneDescartante.setIdDescartante(descartante);
        return telefoneDescartante;
    }

    public TelefoneDescartante convertAtualizar(Integer idTelefone, Descartante idDescartante){
        return new TelefoneDescartante(idTelefone,this.telefoneDescartante, idDescartante, true);
    }
}

package com.example.coletaseletiva.repository;

import com.example.coletaseletiva.entity.Descarte;
import com.example.coletaseletiva.response.DescarteColetorProjecao;
import com.example.coletaseletiva.response.DescarteDescartanteProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescarteRepository extends JpaRepository <Descarte, Integer> {


    @Query(value = "\tselect" +
            " id_descarte as idDescarte," +
            " data_descarte as dataDescarte," +
            " obs_descartante as obsDescartante," +
            " nome_material as nomeMaterial," +
            " peso_em_kg as pesoEmKg," +
            " volume_em_litros as volumeEmLitros," +
            " registro_adicionado_em as registroAdicionadoEm," +
            " nome_rua_avenida as NomeRuaAvenida" +
            ", numero," +
            " complemento," +
            " bairro," +
            " cep," +
            " cidade," +
            " estado" +
            " from descarte d\n" +
            "\tinner join descartante dt on d.id_descartante = dt.id_descartante\n" +
            "\tinner join endereco_descartante ed on ed.id_endereco = d.id_endereco_descartante\n" +
            "\tinner join material m on m.id_material = d.id_material\n" +
            "\twhere d.ativo = 1" +
            "and d.id_coletor is null", nativeQuery = true)
    List<DescarteColetorProjecao> findDisponiveis();


//    @Query(value = "\tselect" +
//            " id_descarte as idDescarte," +
//            " data_descarte as dataDescarte," +
//            " obs_descartante as obsDescartante," +
//            " nome_material as nomeMaterial," +
//            " peso_em_kg as pesoEmKg," +
//            " volume_em_litros as volumeEmLitros," +
//            " registro_adicionado_em as registroAdicionadoEm," +
//            " nome_rua_avenida as NomeRuaAvenida" +
//            ", numero," +
//            " complemento," +
//            " bairro," +
//            " cep," +
//            " cidade," +
//            " estado" +
//            "nome as nomeColetor," +
//            "sobrenome as sobrenomeColetor" +
//            " from descarte d\n" +
//            "\tinner join descartante dt on d.id_descartante = dt.id_descartante\n" +
//            "\tinner join endereco_descartante ed on ed.id_endereco = d.id_endereco_descartante\n" +
//            "\tinner join material m on m.id_material = d.id_material\n" +
//            "\tinner left  join coletor c on c.id_coletor = d.id_coletor" +
//            "\twhere d.ativo = 1" +
//            "\tand d.id_descartante = ?1", nativeQuery = true)
//    List<DescarteDescartanteProjecao> findDescartesAssociados(Integer idDescartante);

    @Query(value = "\tselect" +
            " id_descarte as idDescarte," +
            " data_descarte as dataDescarte," +
            " obs_descartante as obsDescartante," +
            " nome_material as nomeMaterial," +
            " peso_em_kg as pesoEmKg," +
            " volume_em_litros as volumeEmLitros," +
            " registro_adicionado_em as registroAdicionadoEm," +
            " nome_rua_avenida as NomeRuaAvenida" +
            ", numero," +
            " complemento," +
            " bairro," +
            " cep," +
            " cidade," +
            " estado," +
            " c.nome," +
            " c.sobrenome as sobreNomeColetor" +
            " from descarte d\n" +
            "\tinner join descartante dt on d.id_descartante = dt.id_descartante\n" +
            "\tinner join endereco_descartante ed on ed.id_endereco = d.id_endereco_descartante\n" +
            "\tinner join material m on m.id_material = d.id_material\n" +
            "\tleft  join coletor c on c.id_coletor = d.id_coletor" +
            "\twhere d.ativo = 1" +
            "and d.id_descartante = ?1", nativeQuery = true)
    List<DescarteDescartanteProjecao> findDescartesAssociados(Integer idDescartante);
}
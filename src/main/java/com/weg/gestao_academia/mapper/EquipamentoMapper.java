package com.weg.gestao_academia.mapper;

import com.weg.gestao_academia.DTO.aula.AulaRequisicao;
import com.weg.gestao_academia.DTO.aula.AulaResposta;
import com.weg.gestao_academia.DTO.equipamento.EquipamentoRequisicao;
import com.weg.gestao_academia.DTO.equipamento.EquipamentoResposta;
import com.weg.gestao_academia.model.Aula;
import com.weg.gestao_academia.model.Equipamento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipamentoMapper {

    public Equipamento paraEntidade (EquipamentoRequisicao dto) {
        Equipamento eq = new Equipamento();

        eq.setNome(dto.nome());
        eq.setDataCompra(dto.dataCompra());
        eq.setStatus(dto.status());
        eq.setPesoMaximo(dto.pesoMaximo());
        eq.setMarca(dto.marca());

        return eq;
    }
    public EquipamentoResposta paraResposta (Equipamento eq){
        return new EquipamentoResposta(
                eq.getId(),
                eq.getNome(),
                eq.getMarca(),
                eq.getPesoMaximo(),
                eq.getDataCompra(),
                eq.getStatus()
        );
    }
    public List<EquipamentoResposta> paraLista (List<Equipamento> equipamentos) {

        List<EquipamentoResposta> lista = new ArrayList<>();

        for (Equipamento eq : equipamentos){
            lista.add(paraResposta(eq));
        }

        return lista;
    }
}

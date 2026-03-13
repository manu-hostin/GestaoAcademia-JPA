package com.weg.gestao_academia.mapper;

import com.weg.gestao_academia.DTO.aluno.AlunoRequisicao;
import com.weg.gestao_academia.DTO.aluno.AlunoResposta;
import com.weg.gestao_academia.DTO.aula.AulaRequisicao;
import com.weg.gestao_academia.DTO.aula.AulaResposta;
import com.weg.gestao_academia.model.Aluno;
import com.weg.gestao_academia.model.Aula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AulaMapper {

    public Aula paraEntidade (AulaRequisicao dto) {
        Aula aula = new Aula();

        aula.setSala(dto.sala());
        aula.setNivel(dto.nivel());
        aula.setTitulo(dto.titulo());
        aula.setDuracao(dto.duracao());
        aula.setDiaHora(dto.diaHora());

        return aula;
    }
    public AulaResposta paraResposta (Aula aula){
        return new AulaResposta(

                aula.getId(),
                aula.getTitulo(),
                aula.getNivel(),
                aula.getSala(),
                aula.getDiaHora(),
                aula.getDuracao()

        );
    }

    public List<AulaResposta> paraListar(List<Aula> aulas) {
        List<AulaResposta> lista = new ArrayList<>();

        for (Aula aula : aulas){
            lista.add(paraResposta(aula));
        }
        return lista;
    }
}

package com.weg.gestao_academia.service;

import com.weg.gestao_academia.DTO.aula.AulaRequisicao;
import com.weg.gestao_academia.DTO.aula.AulaResposta;
import com.weg.gestao_academia.mapper.AulaMapper;
import com.weg.gestao_academia.model.Aula;
import com.weg.gestao_academia.repository.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final AulaRepository repository;
    private final AulaMapper mapper;

    public AulaResposta criarAula (AulaRequisicao requisicao) {
        Aula aula = mapper.paraEntidade(requisicao);
        Aula salvo = repository.save(aula);

        return mapper.paraResposta(salvo);
    }

    public List<AulaResposta> listarAulas () {
        List<Aula> lista = repository.findAll();
        return mapper.paraListar(lista);
    }

    public AulaResposta buscarPorId (int id) {
        Aula aula = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não cadastrado."));

        return mapper.paraResposta(aula);
    }

    public void deletarAula (int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aula não existe!");
        }
        repository.deleteById(id);
    }

    public AulaResposta atualizarInstrutor (int id, AulaRequisicao requisicao){
        Aula aula = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        aula.setTitulo(requisicao.titulo());
        aula.setSala(requisicao.sala());
        aula.setDuracao(requisicao.duracao());
        aula.setNivel(requisicao.nivel());
        aula.setDiaHora(requisicao.diaHora());

        Aula aulaAtualizada = repository.save(aula);
        return mapper.paraResposta(aulaAtualizada);
    }

}

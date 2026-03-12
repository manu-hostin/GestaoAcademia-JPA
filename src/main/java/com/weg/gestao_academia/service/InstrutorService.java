package com.weg.gestao_academia.service;

import com.weg.gestao_academia.DTO.instrutor.InstrutorRequisicao;
import com.weg.gestao_academia.DTO.instrutor.InstrutorResposta;
import com.weg.gestao_academia.mapper.InstrutorMapper;
import com.weg.gestao_academia.model.Aluno;
import com.weg.gestao_academia.model.Instrutor;
import com.weg.gestao_academia.repository.InstrutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrutorService {

    private final InstrutorRepository repository;
    private final InstrutorMapper mapper;

    public InstrutorResposta criarInstrutor (InstrutorRequisicao requisicao) {
        Instrutor instrutor = mapper.paraEntidade(requisicao);
        Instrutor salvo = repository.save(instrutor);

        return mapper.paraResposta(salvo);
    }

    public List<InstrutorResposta> listarInstrutores () {
        List<Instrutor> lista = repository.findAll();
        return mapper.paraListar(lista);
    }

    public InstrutorResposta buscarPorId (int id) {
        Instrutor instrutor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não cadastrado."));

        return mapper.paraResposta(instrutor);
    }

    public void deletarInstrutor (int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não existe!");
        }
        repository.deleteById(id);
    }

    public InstrutorResposta atualizarInstrutor (int id, InstrutorRequisicao requisicao){
        Instrutor instrutor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));

        instrutor.setNome(requisicao.nome());
        instrutor.setEspecialidade(requisicao.especialidade());
        instrutor.setEmail(requisicao.email());
        instrutor.setTurno(requisicao.turno());
        instrutor.setSalario(requisicao.salario());

        Instrutor instrutorAtualizado = repository.save(instrutor);
        return mapper.paraResposta(instrutorAtualizado);
    }
}

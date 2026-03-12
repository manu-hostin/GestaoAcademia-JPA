package com.weg.gestao_academia.service;

import com.weg.gestao_academia.DTO.equipamento.EquipamentoRequisicao;
import com.weg.gestao_academia.DTO.equipamento.EquipamentoResposta;
import com.weg.gestao_academia.mapper.EquipamentoMapper;
import com.weg.gestao_academia.model.Equipamento;
import com.weg.gestao_academia.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoMapper mapper;
    private final EquipamentoRepository repository;

    public EquipamentoResposta cadastrarEquipamento (EquipamentoRequisicao equipamentoRequisicao) {
        Equipamento equipamento = mapper.paraEntidade(equipamentoRequisicao);
        Equipamento salvo = repository.save(equipamento);

        return mapper.paraResposta(salvo);
    }

    public List<EquipamentoResposta> listarEquipamentos () {
        List<Equipamento> lista = repository.findAll();

        return mapper.paraLista(lista);
    }

    public EquipamentoResposta buscarEquipamento (int id) {
        Equipamento eq = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não existe!"));
        return mapper.paraResposta(eq);
    }

    public void deletarEquipamento (int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Equipamento não existe");
        }

        repository.deleteById(id);
    }
    public EquipamentoResposta atualizarEquipamento (int id, EquipamentoRequisicao equipamentoRequisicao) {
        Equipamento equipamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não existe"));

        equipamento.setNome(equipamentoRequisicao.nome());
        equipamento.setStatus(equipamentoRequisicao.status());
        equipamento.setMarca(equipamentoRequisicao.marca());
        equipamento.setPesoMaximo(equipamentoRequisicao.pesoMaximo());
        equipamento.setDataCompra(equipamentoRequisicao.dataCompra());

        Equipamento atualizado = repository.save(equipamento);
        return mapper.paraResposta(atualizado);

    }


}

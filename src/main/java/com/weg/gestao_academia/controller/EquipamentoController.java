package com.weg.gestao_academia.controller;

import com.weg.gestao_academia.DTO.equipamento.EquipamentoRequisicao;
import com.weg.gestao_academia.DTO.equipamento.EquipamentoResposta;
import com.weg.gestao_academia.service.EquipamentoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService service;

    @PostMapping("/cadastrar")
    public EquipamentoResposta cadastrarEquipamento (@RequestBody EquipamentoRequisicao requisicao) {
        return service.cadastrarEquipamento(requisicao);
    }

    @GetMapping("/listar")
    public List<EquipamentoResposta> listarEquipamentos () {
        return service.listarEquipamentos();
    }

    @GetMapping("/listar/{id}")
    public EquipamentoResposta buscarPorId (@PathVariable int id) {
        return service.buscarEquipamento(id);
    }

    @PutMapping("/atualizar/{id}")
    public EquipamentoResposta atualizarEquipamento (@PathVariable int id, @RequestBody EquipamentoRequisicao equipamentoRequisicao) {
        return service.atualizarEquipamento(id, equipamentoRequisicao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEquipamento (@PathVariable int id) {
        service.deletarEquipamento(id);
    }
}

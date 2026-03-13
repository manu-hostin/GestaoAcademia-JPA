package com.weg.gestao_academia.controller;

import com.weg.gestao_academia.DTO.aula.AulaRequisicao;
import com.weg.gestao_academia.DTO.aula.AulaResposta;
import com.weg.gestao_academia.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final AulaService service;

    @PostMapping("/cadastrar")
    public AulaResposta cadastrarInstrutor (@RequestBody AulaRequisicao requisicao) {
        return service.criarAula(requisicao);
    }

    @GetMapping("/listar")
    public List<AulaResposta> buscarAulas () {
        return service.listarAulas();
    }

    @GetMapping("/listar/{id}")
    public AulaResposta buscarPorId (@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public AulaResposta atualizarInstrutor (@PathVariable int id, @RequestBody AulaRequisicao requisicao) {
        return service.atualizarInstrutor(id, requisicao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarInstrutor (@PathVariable int id) {
        service.deletarAula(id);
    }

}

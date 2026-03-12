package com.weg.gestao_academia.controller;

import com.weg.gestao_academia.DTO.instrutor.InstrutorRequisicao;
import com.weg.gestao_academia.DTO.instrutor.InstrutorResposta;
import com.weg.gestao_academia.service.InstrutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService service;

    @PostMapping("/cadastrar")
    public InstrutorResposta cadastrarInstrutor (@RequestBody InstrutorRequisicao requisicao) {
        return service.criarInstrutor(requisicao);
    }

    @GetMapping("/listar")
    public List<InstrutorResposta> buscarInstrutores () {
        return service.listarInstrutores();
    }

    @GetMapping("/listar/{id}")
    public InstrutorResposta buscarPorId (@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public InstrutorResposta atualizarInstrutor (@PathVariable int id, @RequestBody InstrutorRequisicao requisicao) {
        return service.atualizarInstrutor(id, requisicao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarInstrutor (@PathVariable int id) {
        service.deletarInstrutor(id);
    }

}

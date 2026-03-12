package com.weg.gestao_academia.mapper;

import com.weg.gestao_academia.DTO.equipamento.EquipamentoRequisicao;
import com.weg.gestao_academia.DTO.equipamento.EquipamentoResposta;
import com.weg.gestao_academia.DTO.instrutor.InstrutorRequisicao;
import com.weg.gestao_academia.DTO.instrutor.InstrutorResposta;
import com.weg.gestao_academia.model.Equipamento;
import com.weg.gestao_academia.model.Instrutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstrutorMapper {

    public Instrutor paraEntidade (InstrutorRequisicao dto) {
        Instrutor instrutor = new Instrutor();

        instrutor.setNome(dto.nome());
        instrutor.setEmail(dto.email());
        instrutor.setTurno(dto.turno());
        instrutor.setEspecialidade(dto.especialidade());
        instrutor.setSalario(dto.salario());

        return instrutor;
    }
    public InstrutorResposta paraResposta (Instrutor instrutor){
        return new InstrutorResposta(

            instrutor.getId(),
            instrutor.getNome(),
            instrutor.getEmail(),
            instrutor.getTurno(),
            instrutor.getSalario(),
            instrutor.getEspecialidade()

        );
    }
    public List<InstrutorResposta> paraListar (List<Instrutor> instrutores) {
        List<InstrutorResposta> lista = new ArrayList<>();

        for (Instrutor instrutor : instrutores){
            lista.add(paraResposta(instrutor));
        }
        return lista;
    }

}

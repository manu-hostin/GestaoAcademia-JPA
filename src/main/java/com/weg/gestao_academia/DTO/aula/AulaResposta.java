package com.weg.gestao_academia.DTO.aula;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public record AulaResposta (

        int id,

        String titulo,

        String nivel,

        int sala,

        LocalDateTime diaHora,

        Double duracao
){}

package com.weg.gestao_academia.DTO.aula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public record AulaRequisicao (

        @NotBlank(message = "Digite um título")
        String titulo,

        @NotBlank(message = "Digite um nível")
        String nivel,

        @Positive
        int sala,

        @NotNull(message = "Por favor, digite uma data")
        LocalDateTime diaHora,

        @NotNull(message = "Digite a duração da aula")
        Double duracao
){}

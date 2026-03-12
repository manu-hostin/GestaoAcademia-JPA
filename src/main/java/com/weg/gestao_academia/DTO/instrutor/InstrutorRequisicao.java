package com.weg.gestao_academia.DTO.instrutor;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public record InstrutorRequisicao (

    String nome,

    String email,

    String especialidade,

    Double salario,

    String turno
){}
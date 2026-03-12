package com.weg.gestao_academia.DTO.instrutor;

import lombok.Getter;
import lombok.Setter;

public record InstrutorResposta (

    int id,

    String nome,

    String email,

    String especialidade,

    Double salario,

    String turno
){}

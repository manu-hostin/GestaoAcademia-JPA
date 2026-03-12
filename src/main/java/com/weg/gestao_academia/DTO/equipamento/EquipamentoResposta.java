package com.weg.gestao_academia.DTO.equipamento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public record EquipamentoResposta (

    int id,

    String nome,

    String marca,

    Long pesoMaximo,

    LocalDateTime dataCompra,

    String status
){}

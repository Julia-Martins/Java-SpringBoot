package com.example.tarefa_4_api.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosCursosDTO {
    private Integer id;
    private String descricao;
    private double cargaHoraria;
    private String objetivos;
    private String ementa;
    private List<ProfessoresDTO> professores;
}

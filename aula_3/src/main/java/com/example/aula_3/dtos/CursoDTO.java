package com.example.aula_3.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CursoDTO {
    private Integer id;
    private String name;
    private Integer cargaHoraria;
    private Integer categoriaCurso_id;
    
}

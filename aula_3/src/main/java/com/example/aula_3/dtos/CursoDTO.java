package com.example.aula_3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoDTO {
    private int id;
    private String name;
    private int cargaHoraria;
    private int categoriaCurso_id;

    
}

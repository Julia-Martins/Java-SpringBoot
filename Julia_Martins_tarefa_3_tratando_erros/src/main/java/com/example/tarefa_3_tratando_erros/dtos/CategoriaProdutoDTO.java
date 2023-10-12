package com.example.tarefa_3_tratando_erros.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaProdutoDTO {
    private Integer id_categoria;
    private String name;
}

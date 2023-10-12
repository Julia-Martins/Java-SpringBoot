package com.example.tarefa_3_tratando_erros.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private double preco;
    private Integer id_categoriaProd;
}

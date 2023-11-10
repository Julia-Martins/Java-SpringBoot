package com.example.tarefa_4_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProfessoresDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
}

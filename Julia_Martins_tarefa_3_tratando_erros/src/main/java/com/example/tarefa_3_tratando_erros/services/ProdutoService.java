package com.example.tarefa_3_tratando_erros.services;

import java.util.List;

import com.example.tarefa_3_tratando_erros.dtos.DadosProdutoDTO;
import com.example.tarefa_3_tratando_erros.dtos.ProdutoDTO;
import com.example.tarefa_3_tratando_erros.models.Produto;

public interface ProdutoService {
    Produto salvar(ProdutoDTO produtoDTO);
    List<ProdutoDTO> listAll();
    DadosProdutoDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, ProdutoDTO dto);
}

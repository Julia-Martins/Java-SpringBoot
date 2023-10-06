package com.example.aula_3.services;

import java.util.List;

import com.example.aula_3.dtos.CursoDTO;
import com.example.aula_3.dtos.DadosCursoDTO;
import com.example.aula_3.models.Curso;

public interface CursoService {
    Curso salvar(CursoDTO cursoDTO);
    List<CursoDTO> listarTodos();
    DadosCursoDTO obterPorId(Integer id);
    void excluir(Integer id);
    void editar(Integer id, CursoDTO dto);
}

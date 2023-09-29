package com.example.aula_3.services;

import java.util.List;

import com.example.aula_3.dtos.CursoDTO;
import com.example.aula_3.models.Curso;

public interface CursoService {
    Curso salvar(CursoDTO cursoDTO);
    List<CursoDTO> listarTodos();
    // Curso obterTodosPorId(CursoDTO cursoDTO);
}

package com.example.tarefa_4_api.services;

import java.util.List;

import com.example.tarefa_4_api.dtos.CursosDTO;
import com.example.tarefa_4_api.dtos.DadosCursosDTO;
import com.example.tarefa_4_api.models.Cursos;

public interface CursosService {
    Cursos salvarCurso(CursosDTO cursosDTO);
    List<CursosDTO> listarCursos();

    DadosCursosDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, CursosDTO dto);
}

package com.example.tarefa_4_api.services;

import java.util.List;

import com.example.tarefa_4_api.dtos.DadosProfessoresDTO;
import com.example.tarefa_4_api.dtos.ProfessoresDTO;
import com.example.tarefa_4_api.models.Professores;

public interface ProfessoresService {
    Professores salvar(ProfessoresDTO professoresDTO);
    List<ProfessoresDTO> listarTodos();

    DadosProfessoresDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, ProfessoresDTO dto);
}

package com.example.tarefa_4_api.services;

import java.util.List;

import com.example.tarefa_4_api.dtos.AgendaDTO;
import com.example.tarefa_4_api.dtos.DadosAgendaDTO;
import com.example.tarefa_4_api.models.Agenda;

public interface AgendaService {
    Agenda salvarAgenda(AgendaDTO agendaDTO);
    List<AgendaDTO> listarAgenda();

    DadosAgendaDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, AgendaDTO dto);
}

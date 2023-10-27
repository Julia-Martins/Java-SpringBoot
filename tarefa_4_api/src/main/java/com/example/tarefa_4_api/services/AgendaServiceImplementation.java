package com.example.tarefa_4_api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa_4_api.dtos.AgendaDTO;
import com.example.tarefa_4_api.dtos.CursosDTO;
import com.example.tarefa_4_api.dtos.DadosAgendaDTO;
import com.example.tarefa_4_api.dtos.ProfessoresDTO;
import com.example.tarefa_4_api.exceptions.RegraNegocioException;
import com.example.tarefa_4_api.models.Agenda;
import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;
import com.example.tarefa_4_api.repositories.AgendaRepository;
import com.example.tarefa_4_api.repositories.CursosRepository;
import com.example.tarefa_4_api.repositories.ProfessoresRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaServiceImplementation implements AgendaService {
    private final ProfessoresRepository professoresRepository;
    private final CursosRepository cursosRepository;
    private final AgendaRepository agendaRepository;

    @Override
    public List<AgendaDTO> listarAgenda() {
        List<AgendaDTO> agenda = agendaRepository.findAll().stream().map(
            (Agenda a) -> {
                return AgendaDTO.builder()
                .id(a.getId())
                .dataInicio(a.getDataInicio())
                .dataFinal(a.getDataFinal())
                .horarioInicio(a.getHorarioInicio())
                .horarioFim(a.getHorarioFim())
                .cidade(a.getCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .professores_id(a.getProfessores().getId() != null ? a.getProfessores().getId(): 0)
                .curso_id(a.getCursos().getId() != null ? a.getCursos().getId(): 0)
                .build();
            }
        ).collect(Collectors.toList());

        return agenda;
    }

    @Override
    public Agenda salvarAgenda(AgendaDTO agendaDTO) {
        Cursos cursos = cursosRepository.findById(agendaDTO.getCurso_id()).orElseThrow(
            () -> new RegraNegocioException("Curso não Encontrado")
        );

        Professores professores = professoresRepository.findById(agendaDTO.getProfessores_id()).orElseThrow(
            () -> new RegraNegocioException("Professor não encontrado")
        );

        Agenda a = new Agenda();
        a.setCursos(cursos);
        a.setProfessores(professores);
        a.setDataInicio(agendaDTO.getDataInicio());
        a.setDataFinal(agendaDTO.getDataFinal());
        a.setHorarioInicio(agendaDTO.getHorarioInicio());
        a.setHorarioFim(agendaDTO.getHorarioFim());
        a.setCidade(agendaDTO.getCidade());
        a.setEstado(agendaDTO.getEstado());
        a.setCep(agendaDTO.getCep());

        a.setDataInicio(a.getDataInicio() != null ? a.getDataInicio() : LocalDate.now());
        a.setDataFinal(a.getDataFinal() != null ? a.getDataFinal() : LocalDate.now());

        return agendaRepository.save(a);
    }

    @Override
    public DadosAgendaDTO obtainById(Integer id) {
        return agendaRepository.findById(id).map(
            (Agenda ag) -> {
                return DadosAgendaDTO.builder()
                .id(ag.getId())
                .professores(ag.getProfessores() != null ?
                    ProfessoresDTO.builder()
                    .id(ag.getProfessores().getId())
                    .nome(ag.getProfessores().getNome())
                    .cpf(ag.getProfessores().getCpf())
                    .rg(ag.getProfessores().getRg())
                    .endereco(ag.getProfessores().getEndereco())
                    .celular(ag.getProfessores().getCelular())
                    .build() : null)

                .cursos(ag.getCursos() != null ?
                    CursosDTO.builder()
                    .id(ag.getCursos().getId())
                    .descricao(ag.getCursos().getDescricao())
                    .cargaHoraria(ag.getCursos().getCargaHoraria())
                    .objetivos(ag.getCursos().getObjetivos())
                    .ementa(ag.getCursos().getEmenta())
                    .build() : null)

                .dataInicio(ag.getDataInicio())
                .dataFinal(ag.getDataFinal())
                .horarioInicio(ag.getHorarioInicio())
                .horarioFim(ag.getHorarioFim())
                .cidade(ag.getCidade())
                .estado(ag.getEstado())
                .cep(ag.getCep())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("Agenda não foi encontrada com o ID Fornecido!")
        );
    }

    @Override
    public void delete(Integer id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Agenda não foi encontrada com o ID Fornecido!")
        );
        agendaRepository.deleteById(agenda.getId());
    }

    @Override
    public void update(Integer id, AgendaDTO dto) {
        Cursos cursos = cursosRepository.findById(dto.getCurso_id()).orElseThrow(
            () -> new RegraNegocioException("Curso não Encontrado")
        );

        Professores professores = professoresRepository.findById(dto.getProfessores_id()).orElseThrow(
            () -> new RegraNegocioException("Professor não encontrado")
        );

        Agenda agenda = agendaRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Agenda não encontrado")
        );

        agenda.setCursos(cursos);
        agenda.setProfessores(professores);
        agenda.setDataInicio(dto.getDataInicio() != null ? dto.getDataInicio() : LocalDate.now());
        agenda.setDataFinal(dto.getDataFinal() != null ? dto.getDataFinal() : LocalDate.now());
        agenda.setHorarioInicio(dto.getHorarioInicio());
        agenda.setHorarioFim(dto.getHorarioFim());
        agenda.setCidade(dto.getCidade());
        agenda.setEstado(dto.getEstado());
        agenda.setCep(dto.getCep());

        agendaRepository.save(agenda);
    }
    
}

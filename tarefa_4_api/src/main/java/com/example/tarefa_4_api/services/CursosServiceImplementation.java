package com.example.tarefa_4_api.services;

import com.example.tarefa_4_api.dtos.CursosDTO;
import com.example.tarefa_4_api.dtos.DadosCursosDTO;
import com.example.tarefa_4_api.dtos.ProfessoresDTO;
import com.example.tarefa_4_api.exceptions.RegraNegocioException;
import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;
import com.example.tarefa_4_api.repositories.AgendaRepository;
import com.example.tarefa_4_api.repositories.CursosRepository;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursosServiceImplementation implements CursosService {

  private final CursosRepository cursosRepository;
  private final AgendaRepository agendaRepository;

  @Override
  public Cursos salvarCurso(CursosDTO cursosDTO) {
    Cursos c = new Cursos();
    c.setDescricao(cursosDTO.getDescricao());
    c.setCargaHoraria(cursosDTO.getCargaHoraria());
    c.setObjetivos(cursosDTO.getObjetivos());
    c.setEmenta(cursosDTO.getEmenta());
    return cursosRepository.save(c);
  }

  @Override
  public List<CursosDTO> listarCursos() {
    List<CursosDTO> cursos = cursosRepository
      .findAll()
      .stream()
      .map((Cursos c) -> {
        return CursosDTO
          .builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivos(c.getObjetivos())
          .ementa(c.getEmenta())
          .build();
      })
      .collect(Collectors.toList());

    return cursos;
  }

  @Override
  public DadosCursosDTO obtainById(Integer id) {
    return cursosRepository
      .findCursosFetchProfessores(id)
      .map((Cursos c) -> {
        return DadosCursosDTO
          .builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivos(c.getObjetivos())
          .ementa(c.getEmenta())
          .professores(
            c.getProfessores() != null
              ? c
                .getProfessores()
                .stream()
                .map((Professores p) -> {
                  return ProfessoresDTO
                    .builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .cpf(p.getCpf())
                    .rg(p.getRg())
                    .endereco(p.getEndereco())
                    .celular(p.getCelular())
                    .build();
                })
                .collect(Collectors.toList())
              : null
          )
          .build();
      })
      .orElseThrow(() ->
        new RegraNegocioException("Curso não encontrado com o ID fornecido!")
      );
  }

  @Override
  public void delete(Integer id) {
    Cursos cursos = cursosRepository
      .findById(id)
      .orElseThrow(() ->
        new RegraNegocioException("Código de curso não encontrado.")
      );

    if (agendaRepository.existsByCursosId(cursos.getId())) {
      throw new RegraNegocioException(
        "Curso está em alguma agenda, não pode ser excluído!"
      );
    }

    cursosRepository.deleteById(id);
  }

  @Override
  public void update(Integer id, CursosDTO dto) {
    Cursos cursos = cursosRepository
      .findById(id)
      .orElseThrow(() ->
        new RegraNegocioException("Código de curso não encontrado.")
      );

    cursos.setDescricao(dto.getDescricao());
    cursos.setCargaHoraria(dto.getCargaHoraria());
    cursos.setObjetivos(dto.getObjetivos());
    cursos.setEmenta(dto.getEmenta());
    cursosRepository.save(cursos);
  }
}

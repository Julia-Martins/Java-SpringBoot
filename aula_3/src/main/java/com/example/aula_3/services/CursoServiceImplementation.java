package com.example.aula_3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.aula_3.dtos.CategoriaCursoDTO;
import com.example.aula_3.dtos.CursoDTO;
import com.example.aula_3.dtos.DadosCursoDTO;
import com.example.aula_3.exceptions.RegraNegocioException;
import com.example.aula_3.models.CategoriaCurso;
import com.example.aula_3.models.Curso;
import com.example.aula_3.repository.CategoriaCursoRepository;
import com.example.aula_3.repository.CursoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImplementation implements CursoService {
    private final CursoRepository cursoRepository;
    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public Curso salvar(CursoDTO cursoDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
            cursoDTO.getCategoriaCurso_id()).orElseThrow(
                () -> new RegraNegocioException("Código da categoria não foi encontrado!")
            );
    

        Curso c = new Curso();
        c.setCargaHoraria(cursoDTO.getCargaHoraria());
        c.setCategoriaCurso(categ);
        c.setName(cursoDTO.getName());
        return cursoRepository.save(c);
    }

    public List<CursoDTO> listarTodos(){
        List<CursoDTO> cursos = cursoRepository.findAll().stream().map(
            (Curso c) -> {
                return CursoDTO.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoriaCurso_id(c.getCategoriaCurso() != null ? c.getCategoriaCurso().getId(): 0)

                    .build();
            }
            
        ).collect(Collectors.toList());  

        return cursos;
    }

    @Override
    public DadosCursoDTO obterPorId(Integer id) {
        return cursoRepository.findById(id).map(
            (Curso c) -> {
                return DadosCursoDTO.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoria(c.getCategoriaCurso() != null ?
                        CategoriaCursoDTO.builder()
                        .id(c.getCategoriaCurso().getId())
                        .name(c.getCategoriaCurso().getName())        
                        .build() : null
                ).build();
            }
        
        ).orElseThrow(
            () -> new RegraNegocioException("Curso não encontrado com o ID fornecido!")
        );
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void editar(Integer id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Código usuário não encontrado."));

        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(dto.getCategoriaCurso_id())
        .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));
        
        curso.setName(dto.getName());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
}
    
}


// List<CursoDTO> cursoDTO = new ArrayList<>();
//         for(Curso c : cursos){
//             cursoDTO.add( new CursoDTO(
//                 c.getId(),
//                 c.getName(),
//                 c.getCargaHoraria(),
//                 c.getCategoriaCurso() != null ? c.getCategoriaCurso().getId() : 0
//                 )
//             );
//         }
package com.example.aula_3.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aula_3.dtos.CursoDTO;
import com.example.aula_3.exceptions.RegraNegocioException;
import com.example.aula_3.models.CategoriaCurso;
import com.example.aula_3.models.Curso;
import com.example.aula_3.repository.CategoriaCursoRepository;
import com.example.aula_3.repository.CursoRepository;

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
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoDTO> cursoDTO = new ArrayList<>();
        for(Curso c : cursos){
            cursoDTO.add( new CursoDTO(
                c.getId(),
                c.getName(),
                c.getCargaHoraria(),
                c.getCategoriaCurso() != null ? c.getCategoriaCurso().getId() : 0
                )
            );
        }

        return cursoDTO;
    }
    
}

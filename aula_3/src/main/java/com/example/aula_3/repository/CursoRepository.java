package com.example.aula_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.aula_3.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
    List<Curso> findByNameLike(String name);
}

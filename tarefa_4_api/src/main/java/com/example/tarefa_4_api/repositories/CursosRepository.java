package com.example.tarefa_4_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa_4_api.models.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    @Query("SELECT cs FROM Cursos cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    Optional<Cursos> findCursosFetchProfessores(@Param("id") Integer id);
}

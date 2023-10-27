package com.example.tarefa_4_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;

public interface ProfessoresRepository extends JpaRepository<Professores, Integer> {
    @Query("SELECT cs FROM Cursos cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    Cursos findCursosFetchProfessores(@Param("id") Integer id);
}

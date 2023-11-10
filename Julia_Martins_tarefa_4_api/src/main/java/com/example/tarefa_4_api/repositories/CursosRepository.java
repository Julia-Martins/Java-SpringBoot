package com.example.tarefa_4_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa_4_api.models.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    @Query("select cc from Cursos cc left join fetch cc.professores where cc.id = :id")
    Optional<Cursos> findCursosByIdFetchProfessores(@Param("id") Integer id);
}

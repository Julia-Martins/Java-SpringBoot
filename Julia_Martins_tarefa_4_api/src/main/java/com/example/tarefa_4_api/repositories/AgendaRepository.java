package com.example.tarefa_4_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa_4_api.models.Agenda;

import java.time.LocalDate;
import java.util.List;


public interface AgendaRepository extends JpaRepository<Agenda, Integer>{
    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.professores.id = :id")
    List<Agenda> findAgendaByIdProfessoresFetchProfessores(@Param("id") Integer professores_id);

    @Query("SELECT ag FROM Agenda ag inner JOIN FETCH ag.professores WHERE ag.dataInicio = :dataInicio AND ag.professores.id = :id")
    Agenda findAgendaFetchDataInicioProfessores(@Param("dataInicio") LocalDate dataInicio, @Param("id") Integer id);

    boolean existsByProfessoresId(Integer id);
    boolean existsByCursosId(Integer id);
}

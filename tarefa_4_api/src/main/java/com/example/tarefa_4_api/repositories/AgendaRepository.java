package com.example.tarefa_4_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa_4_api.models.Agenda;
import java.sql.Date;


public interface AgendaRepository extends JpaRepository<Agenda, Integer>{
    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.id = :id")
    Agenda findAgendaFetchProfessores(@Param("id") Integer id);

    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.dataInicio = :dataInicio")
    Agenda findByDataFinal(@Param("dataInicio") Date dataInicio);

    boolean existsByProfessoresId(Integer id);

    boolean existsByCursosId(Integer id);
}

package com.example.tarefa_4_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataInicio;
    @NotNull(message = "Data Final não pode ser vazia")
    private LocalDate dataFinal;
    private String horarioInicio;
    private String horarioFim;
    private String cidade;
    private String estado;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "professores_id")
    private Professores professores;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos cursos;

    public Agenda(Integer id, LocalDate dataInicio, LocalDate dataFinal, String horarioInicio, String horarioFim,
                  String cidade, String estado, String cep) {
        this.id = id;
         this.dataInicio = dataInicio;
         this.dataFinal = dataFinal;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Agenda() {
    }

    @Override
    public String toString() {
        return "[ Id: " + id + 
               "\nData Início: " + dataInicio +
               "\nData Final: " + dataFinal + 
               "\nHorário Início: " + horarioInicio + 
               "\nHorário Final: " + horarioFim +
               "\nCidade: " + cidade + 
               "\nEstado: " + estado + 
               "\nCEP: " + cep + " ]";
    }

}
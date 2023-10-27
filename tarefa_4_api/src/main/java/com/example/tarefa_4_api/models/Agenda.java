package com.example.tarefa_4_api.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;
    private String horarioInicio;
    private String horarioFim;
    private String cidade;
    private String estado;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "professores_id")
    private Professores professores;

    public Professores getProfessores() {
        return professores;
    }
    
    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos cursos;

    public Cursos getCursos() {
        return cursos;
    }
    
    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Agenda(Integer id, LocalDate dataInicio, LocalDate dataFinal, String horarioInicio, String horarioFim,
                  String cidade, String estado, String cep, Integer professor_id, Integer curso_id) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;

        professores = new Professores();
        professores.setId(professor_id);
        
        cursos = new Cursos();
        cursos.setId(curso_id); 
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

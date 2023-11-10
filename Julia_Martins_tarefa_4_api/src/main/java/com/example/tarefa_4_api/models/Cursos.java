package com.example.tarefa_4_api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private double cargaHoraria;
    private String objetivos;
    private String ementa;
    
    public Cursos() {
    }

    public Cursos(Integer id, String descricao, double cargaHoraria, String objetivos, String ementa) {
        this.id = id;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.objetivos = objetivos;
        this.ementa = ementa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cursos_professores", joinColumns = {
        @JoinColumn(name = "professores_id")
    },
        inverseJoinColumns = {
            @JoinColumn(name = "cursos_id")
        }
    )
    private List<Professores> professores = new ArrayList<>();

    public List<Professores> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professores> professores) {
        this.professores = professores;
    }

    @OneToMany(mappedBy = "cursos")
    private List<Agenda> agenda;

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "[ Id: " + id +
                "\nDescricao: " + descricao + 
                "\nCarga Horaria: " + cargaHoraria +
                "\nObjetivos: " + objetivos + 
                "\nEmenta: " + ementa + " ]";
    }
    
}
                // "\nProfessores: " + getProfessores() +

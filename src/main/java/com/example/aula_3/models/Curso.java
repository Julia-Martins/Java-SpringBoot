package com.example.aula_3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(nullable = false)
    private int cargaHoraria;

    public Curso() {
    }

    public Curso(int id, String name, int cargaHoraria){
        this.id = id;
        this.name = name;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @ManyToOne
    @JoinColumn(name="categoriaCurso_id")
    private CategoriaCurso categoriaCurso;

    public CategoriaCurso getCategoriaCurso(){
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso){
        this.categoriaCurso = categoriaCurso;
    }

    @Override
    public String toString() {
        return "Curso [id = " + id + ", name = " + name + ", cargaHoraria = " + cargaHoraria + "]";
    }

    
}

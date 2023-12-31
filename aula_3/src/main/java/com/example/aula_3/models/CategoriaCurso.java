package com.example.aula_3.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaCurso{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "categoriaCurso"/*, fetch = FetchType.EAGER*/)
    private List<Curso> cursos_test;

    public CategoriaCurso(){}

    public CategoriaCurso(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "categoriaCurso")
    private List<Curso> cursos;

    public List<Curso> getCursos(){
        return cursos;
    }

    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }   


}
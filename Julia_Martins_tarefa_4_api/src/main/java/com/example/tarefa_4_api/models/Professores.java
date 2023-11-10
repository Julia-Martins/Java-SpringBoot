package com.example.tarefa_4_api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;

    public Professores(){}

    public Professores(Integer id, String nome, String cpf, String rg, String endereco, String celular){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = cpf;
        this.endereco = endereco;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    @ManyToMany(mappedBy = "professores", fetch = FetchType.EAGER)
    private List<Cursos> cursos = new ArrayList<>();

    public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }

    @OneToMany(mappedBy = "professores")
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
               "\nNome: " + nome +
               "\nCPF: " + cpf + 
               "\nRG: " + rg + 
               "\nEndereço: " + endereco + 
               "\nCelular: " + celular + " ]";
    }
} 

// "\nCursos: " + getCursos() +
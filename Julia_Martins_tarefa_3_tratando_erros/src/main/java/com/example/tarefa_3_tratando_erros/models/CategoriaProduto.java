package com.example.tarefa_3_tratando_erros.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    private String name;

    public CategoriaProduto(){}

    public CategoriaProduto(Integer id_categoria, String name){
        this.id_categoria = id_categoria;
        this.name = name;
    }
    
    public Integer getId_categoria() {
        return id_categoria;
    }
    
    public String getName() {
        return name;
    }
    
    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy = "categoriaProduto")
    private List<Produto> produtos;
    
    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    @Override
    public String toString(){
        return "CategoriaProduto[id_categoria = " + id_categoria + ", name = " + name + "]";
    }
}

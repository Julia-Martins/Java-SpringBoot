package com.example.tarefa_3_tratando_erros.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;

    public Produto(){}
    
    public Produto(Integer id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @ManyToOne
    @JoinColumn(name = "id_categoriaProd")
    private CategoriaProduto categoriaProduto;
    
    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }
    
    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    
    @Override
    public String toString(){
        return "Produto[Id = " + id + ", Nome = " +
                nome + ", Preço = " + preco + "]";
    }
}

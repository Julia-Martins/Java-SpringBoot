package com.example.tarefa_2_jpa_repository_query_method.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

@Entity
// @Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;

    public Produto(){}
    
    public Produto(Long id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(Long id) {
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

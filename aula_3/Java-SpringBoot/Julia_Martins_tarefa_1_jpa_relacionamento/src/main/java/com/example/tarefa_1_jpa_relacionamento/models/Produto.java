package com.example.tarefa_1_jpa_relacionamento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;
    @Column(length = 50, nullable = false)
    private String prod_nome;
    private int prod_qtd;

    public Produto(){}

    public Produto(int id_produto, String prod_nome, int prod_qtd){
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
    }

    public int getId_Produto() {
        return id_produto;
    }

    public void setId_Produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public int getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
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
        return "Produto[id = " + id_produto + ", prod_name = " +
                prod_nome + ", prod_qtd = " + prod_qtd + "]";
    }
}

package com.example.tarefa_1_jpa_relacionamento.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    @Column(length = 30, nullable = false)
    private String cat_name;
    @Column(length = 60)
    private String cat_descricao;

    public CategoriaProduto(){}

    public CategoriaProduto(int id_categoria, String cat_name, String cat_descricao){
        this.id_categoria = id_categoria;
        this.cat_name = cat_name;
        this.cat_descricao = cat_descricao;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_descricao() {
        return cat_descricao;
    }

    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
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
        return "CategoriaProduto[id_categoria = " + id_categoria + ", cat_name = " +
                cat_name + ", cat_descricao = " + cat_descricao + "]";
    }

    
}

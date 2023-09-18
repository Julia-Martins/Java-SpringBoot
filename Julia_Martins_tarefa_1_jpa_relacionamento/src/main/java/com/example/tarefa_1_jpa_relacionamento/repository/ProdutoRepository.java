package com.example.tarefa_1_jpa_relacionamento.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.tarefa_1_jpa_relacionamento.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto insert(Produto produto){
        entityManager.merge(produto);

        return produto;
    }

    @Transactional
    public Produto edit(Produto produto){
        entityManager.merge(produto);

        return produto;
    }

    @Transactional
    private void delete(Produto produto){
        entityManager.remove(produto);
    }

    @Transactional
    public void deleteId(int prod_id){
        delete(entityManager.find(Produto.class, prod_id));
        System.out.println(prod_id);
    }

    @Transactional(readOnly = true)
    public List<Produto> obterProdutoPorId(int id_produto){
        String jpql = "select c from Produto c where c.id_produto = :id_produto";

        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id_produto", id_produto);

        return query.getResultList();
    }

    public List<Produto> obterTodosProdutos(){
        return entityManager.createQuery("from Produto", Produto.class).getResultList();
    }
}

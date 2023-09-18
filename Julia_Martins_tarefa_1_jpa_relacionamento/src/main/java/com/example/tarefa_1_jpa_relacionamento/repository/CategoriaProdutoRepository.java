package com.example.tarefa_1_jpa_relacionamento.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.tarefa_1_jpa_relacionamento.models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaProduto insert(CategoriaProduto categoriaProduto){
        entityManager.persist(categoriaProduto);

        return categoriaProduto;
    }

    @Transactional
    public CategoriaProduto edit(CategoriaProduto categoriaProduto){
        entityManager.merge(categoriaProduto);

        return categoriaProduto;
    }

    @Transactional
    private void delete(CategoriaProduto categoriaProduto){
        entityManager.remove(categoriaProduto);
    }

    @Transactional
    public void deleteId(int id_categoria){
        delete(entityManager.find(CategoriaProduto.class, id_categoria));
    }

    @Transactional(readOnly = true)
    public List<CategoriaProduto> obterCategoriaPorId(int id_categoria){
        String jpql = "SELECT c FROM CategoriaProduto c WHERE c.id_categoria = :id_categoria";

        TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql, CategoriaProduto.class);
        query.setParameter("id_categoria", id_categoria);

        return query.getResultList();
    }

    @Transactional
    public List<CategoriaProduto> obterTodasCategoriaProdutos(){
        return entityManager.createQuery("FROM CategoriaProduto", CategoriaProduto.class).getResultList();
    }

}

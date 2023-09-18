package com.example.aula_3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.aula_3.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso insert(CategoriaCurso categoriaCurso){
        entityManager.persist(categoriaCurso);
        return categoriaCurso;
    }

    public List<CategoriaCurso> obterTodos(){
        return entityManager.createQuery(
            "from CategoriaCurso",
            CategoriaCurso.class
        ).getResultList();
    }

}
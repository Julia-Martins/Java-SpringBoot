package com.example.aula_3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aula_3.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso insert(Curso curso){
        entityManager.merge(curso);

        return curso;
    }

    @Transactional
    public Curso update(Curso curso){
        entityManager.merge(curso);

        return curso;
    }

    @Transactional
    public void delete(Curso curso){
        entityManager.remove(curso);
    }

    @Transactional
    public void deleteId(int id){
        delete(entityManager.find(Curso.class, id));
    }

    @Transactional(readOnly = true)
    public List<Curso> obtainForName(String name){
    String jpql = " select c from Curso c where c.nome like :nome";
    TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
    query.setParameter("nome", "%" + name + "%");
    return query.getResultList();
    }

    public List<Curso> obtainAll(){
        return entityManager.createQuery("from Curso", Curso.class).getResultList();
    }


}

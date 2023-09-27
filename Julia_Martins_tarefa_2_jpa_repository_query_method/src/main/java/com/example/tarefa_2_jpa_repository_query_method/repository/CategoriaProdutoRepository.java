package com.example.tarefa_2_jpa_repository_query_method.repository;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tarefa_2_jpa_repository_query_method.models.CategoriaProduto;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
    @Query("SELECT cp FROM CategoriaProduto cp LEFT JOIN FETCH cp.produtos WHERE cp.id = :id_categoria")
    CategoriaProduto findCategoriaProdutoFetchProduto(@Param("id_categoria") Long id_categoria);

    // @Query("SELECT cp FROM CategoriaProduto cp WHERE cp.name LIKE :name")
    List<CategoriaProduto> findByNameStartingWith(String name);

    // @Query("SELECT cp FROM CategoriaProduto cp LEFT JOIN FETCH cp.Produto p WHERE cp.id = :id_categoria")
    // CategoriaProduto findCategoriaProdutoFetchProduto(@Param("id_categoria") Long id);
}

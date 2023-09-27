package com.example.tarefa_2_jpa_repository_query_method.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.tarefa_2_jpa_repository_query_method.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> findByPrecoProdutos(double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :preco")
    List<Produto> findByPreco(double preco);

    List<Produto> findByNomeLike(String nome);
}

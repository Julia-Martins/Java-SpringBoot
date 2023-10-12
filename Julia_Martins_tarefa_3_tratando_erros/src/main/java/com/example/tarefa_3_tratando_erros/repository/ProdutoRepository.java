package com.example.tarefa_3_tratando_erros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.tarefa_3_tratando_erros.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> findByPrecoProdutos(double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :preco")
    List<Produto> findByPreco(double preco);

    List<Produto> findByNomeLike(String nome);
}

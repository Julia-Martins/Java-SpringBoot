package com.example.tarefa_2_jpa_repository_query_method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa_2_jpa_repository_query_method.models.CategoriaProduto;
import com.example.tarefa_2_jpa_repository_query_method.models.Produto;
import com.example.tarefa_2_jpa_repository_query_method.repository.CategoriaProdutoRepository;
import com.example.tarefa_2_jpa_repository_query_method.repository.ProdutoRepository;

@SpringBootApplication
public class Tarefa2JpaRepositoryQueryMethodApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired ProdutoRepository produtoRepository, 
		@Autowired CategoriaProdutoRepository categoriaProdutoRepository
	){
		return args ->{
			// INSERINDO PRODUTOS

			Produto p1 = new Produto((long) 0, "Lírio", 56.90);
			Produto p2 = new Produto((long) 0, "Dente de Leão", 33.89);
			Produto p3 = new Produto((long) 0, "Túlipa", 60.85);

			Produto p4 = new Produto((long) 0, "Lobo", 500000.0);
			Produto p5 = new Produto((long) 0, "Leão", 200000.0);
			Produto p6 = new Produto((long) 0, "Tigre", 300000.0);
			
			// Produto p7 = new Produto((long) 0, "Túlipa Frufru", 23.85);

			System.out.println("Inserir Produto");		
			System.out.println("Inserindo Plantas");		
			// PRODUTO PLANTA
			p1 = produtoRepository.save(p1);
			p2 = produtoRepository.save(p2);
			p3 = produtoRepository.save(p3);
			
			System.out.println("Inserindo Animais");
			// PRODUTO ANIMAIS
			p4 = produtoRepository.save(p4);
			p5 = produtoRepository.save(p5);
			p6 = produtoRepository.save(p6);

			// p7 = produtoRepository.save(p7);
			
			System.out.println("Selecionar Preço acima do digitado");
			List<Produto> listaProdutos = produtoRepository.findByPrecoProdutos(2000.0);
			listaProdutos.forEach(System.out::println);

			// produtoRepository.delete(p7);
			// listaProdutos = produtoRepository.findAll();

			System.out.println("Selecionar igual ou abaixo do digitado");
			listaProdutos = produtoRepository.findByPreco(30000.0);
			listaProdutos.forEach(System.out::println);

			System.out.println("Selecionar todos os produtos por caracteres digitados");
			listaProdutos = produtoRepository.findByNomeLike("%L%");
			listaProdutos.forEach(System.out::println);

			System.out.println("Selecionar todos");
			listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("Adicionar Categoria Produto");
			CategoriaProduto cp1 = new CategoriaProduto((long) 0, "Plantas");
			CategoriaProduto cp2 = new CategoriaProduto((long) 0, "Animais");
			CategoriaProduto cp3 = new CategoriaProduto((long) 0, "Móveis");

			cp1 = categoriaProdutoRepository.save(cp1);
			cp2 = categoriaProdutoRepository.save(cp2);
			cp3 = categoriaProdutoRepository.save(cp3);

			// Adicionando categoria Plantas
			listaProdutos.get(0).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(0));

			listaProdutos.get(1).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(1));

			listaProdutos.get(2).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(2));

			// // // Adicionando categoria Animais
			listaProdutos.get(3).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(3));

			listaProdutos.get(4).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(4));

			listaProdutos.get(5).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(5));

			System.out.println("Selecionar todas as categorias por caracteres digitados");
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.findByNameStartingWith("A");
			listaCategorias.forEach(System.out::println);

			System.out.println("Produtos relacionado a uma determinada categoria");
			CategoriaProduto cp = categoriaProdutoRepository.findCategoriaProdutoFetchProduto((long) 2);
			System.out.println(cp.getProdutos().toString());

		};
	};
	public static void main(String[] args) {
		SpringApplication.run(Tarefa2JpaRepositoryQueryMethodApplication.class, args);
	}

}

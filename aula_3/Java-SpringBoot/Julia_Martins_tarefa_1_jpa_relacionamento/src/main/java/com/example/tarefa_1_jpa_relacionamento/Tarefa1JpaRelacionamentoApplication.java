package com.example.tarefa_1_jpa_relacionamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa_1_jpa_relacionamento.models.CategoriaProduto;
import com.example.tarefa_1_jpa_relacionamento.models.Produto;
import com.example.tarefa_1_jpa_relacionamento.repository.CategoriaProdutoRepository;
import com.example.tarefa_1_jpa_relacionamento.repository.ProdutoRepository;

@SpringBootApplication
public class Tarefa1JpaRelacionamentoApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired ProdutoRepository produtoRepository,
		@Autowired CategoriaProdutoRepository categoriaProdutoRepository
	){
		return args ->{
			// INSERINDO PRODUTOS
			// PRODUTO PAPELATIA
			produtoRepository.insert(new Produto(0, "Caneta Preta", 30));
			produtoRepository.insert(new Produto(0, "Caneta Azul", 20));
			produtoRepository.insert(new Produto(0, "Caneta Teste", 60));
			produtoRepository.insert(new Produto(0, "Caneta Vermelha", 45));

			// PRODUTO PLANTA
			produtoRepository.insert(new Produto(0, "Lírio", 20));
			produtoRepository.insert(new Produto(0, "Dente de Leão", 10));
			produtoRepository.insert(new Produto(0, "Túlipa", 15));

			// PRODUTO ANIMAIS
			produtoRepository.insert(new Produto(0, "Lobo", 5));
			produtoRepository.insert(new Produto(0, "Leão", 2));
			produtoRepository.insert(new Produto(0, "Tigre", 3));

			List<Produto> listaProduto = produtoRepository.obterTodosProdutos();

			// EDITAR PRODUTOS
			produtoRepository.edit(new Produto(3, "Caneta Vermelha", 40));
			listaProduto = produtoRepository.obterTodosProdutos();

			// EXCLUIR PRODUTOS
			produtoRepository.deleteId(3);
			listaProduto = produtoRepository.obterTodosProdutos();

			// INSERINDO CATEGORIA PRODUTO
			CategoriaProduto cp1 = new CategoriaProduto(0, "Papelaria", "Produtos focados na papelaria.");
			CategoriaProduto cp2 = new CategoriaProduto(0, "Planta", "Produtos focados nas Plantas.");
			CategoriaProduto cp3 = new CategoriaProduto(0, "Animais", "Produtos focados nas Animais.");
			CategoriaProduto cp4 = new CategoriaProduto(0, "Test", "Produtos focados nas Árvores.");

			categoriaProdutoRepository.insert(cp1);
			categoriaProdutoRepository.insert(cp2);
			categoriaProdutoRepository.insert(cp3);
			categoriaProdutoRepository.insert(cp4);

			List<CategoriaProduto> listaCaregoria = categoriaProdutoRepository.obterTodasCategoriaProdutos();

			// EDITAR CATEGORIA PRODUTO
			categoriaProdutoRepository.edit(new CategoriaProduto(4, "Árvores", "Produtos focados nas Árvores."));

			listaCaregoria = categoriaProdutoRepository.obterTodasCategoriaProdutos();
			
			// EXCLUIR CATEGORIA PRODUTO
			categoriaProdutoRepository.deleteId(4);

			listaCaregoria = categoriaProdutoRepository.obterTodasCategoriaProdutos();

			// Adicionar a Categoria ao Produto Papelaria
			listaProduto.get(0).setCategoriaProduto(cp1);
			produtoRepository.insert(listaProduto.get(0));

			listaProduto.get(1).setCategoriaProduto(cp1);
			produtoRepository.insert(listaProduto.get(1));

			listaProduto.get(2).setCategoriaProduto(cp1);
			produtoRepository.insert(listaProduto.get(2));

			// Adicionar a Categoria Produto Planta
			listaProduto.get(3).setCategoriaProduto(cp2);
			produtoRepository.insert(listaProduto.get(3));

			listaProduto.get(4).setCategoriaProduto(cp2);
			produtoRepository.insert(listaProduto.get(4));

			listaProduto.get(5).setCategoriaProduto(cp2);
			produtoRepository.insert(listaProduto.get(5));

			// Adicionar a Categoria Produto Animais
			listaProduto.get(6).setCategoriaProduto(cp3);
			produtoRepository.insert(listaProduto.get(6));

			listaProduto.get(7).setCategoriaProduto(cp3);
			produtoRepository.insert(listaProduto.get(7));

			listaProduto.get(8).setCategoriaProduto(cp3);
			produtoRepository.insert(listaProduto.get(8));
			
			System.out.println("Selecionar todos os Produtos");
			listaProduto = produtoRepository.obterTodosProdutos();
			listaProduto.forEach(System.out::println);

			System.out.println("Selecionar todas as Categorias");
			listaCaregoria = categoriaProdutoRepository.obterTodasCategoriaProdutos();
			listaCaregoria.forEach(System.out::println);

			System.out.println("Selecionar Produto por ID");
			listaProduto = produtoRepository.obterProdutoPorId(8);
			listaProduto.forEach(System.out::println);

			System.out.println("Selecionar Categoria por ID");
			listaCaregoria = categoriaProdutoRepository.obterCategoriaPorId(3);
			listaCaregoria.forEach(System.out::println);
		};
	};


	public static void main(String[] args) {
		SpringApplication.run(Tarefa1JpaRelacionamentoApplication.class, args);
	}

}

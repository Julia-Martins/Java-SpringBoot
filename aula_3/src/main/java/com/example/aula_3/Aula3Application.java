package com.example.aula_3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aula_3.models.CategoriaCurso;
import com.example.aula_3.models.Curso;
import com.example.aula_3.repository.CategoriaCursoRepository;
import com.example.aula_3.repository.CursoRepository;

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository, 
			@Autowired CategoriaCursoRepository categoriaCursoRepository
		){
			return args ->{
				System.out.println("Exemplo inserindo cursos");
				cursoRepository.save(new Curso(0, "Análise e Desenvolvimento de Sistemas", 2000));
				cursoRepository.save(new Curso(0, "Análise de Dados", 1500));

				System.out.println("Selecionar todos");
				List<Curso> listaCursos = cursoRepository.findAll();
				listaCursos.forEach(System.out::println);

				System.out.println("Selecionar por nome");
				listaCursos = cursoRepository.findByNameLike("%De%");
				listaCursos.forEach(System.out::println);
				
				System.out.println("Exemplo inserindo categorias");
				CategoriaCurso c1 = new CategoriaCurso(0, "Área de Tecnologia");
				categoriaCursoRepository.save(c1);

				listaCursos.get(0).setCategoriaCurso(c1);
				cursoRepository.save(listaCursos.get(0));

				// System.out.println("Exemplo Lazy");
				// List<CategoriaCurso> categs = categoriaCursoRepository.findAll();
				// for(CategoriaCurso ca: categs){
				// 	System.out.println(ca.getId() + " - " + ca.getName() + " qtde_cursos: " + ca.getCursos());
				// }

				System.out.println("Exemplo Fetch");
				CategoriaCurso cc = categoriaCursoRepository.findCategoriaCursoFetchCursos((Integer) 1);
				System.out.println(cc.getCursos().size());


			};
	}

	// @Bean
	// public CommandLineRunner init(@Autowired CursoRepository cursoRepository) {
	// 	return args -> {
	// 		cursoRepository.insert(
	// 			new Curso((long) 0, "Análise e Desenvolvimento de Sistemas",2500));

	// 		cursoRepository.insert(
	// 			new Curso((long) 0, "Engenharia da Computação", 5000));

	// 		cursoRepository.insert(
	// 			new Curso((long) 0, "test", 700));

	// 		cursoRepository.insert(
	// 			new Curso((long) 0, "test4", 8000));

	// 		List<Curso> listaCursos = cursoRepository.obtainAll();
	// 		listaCursos.forEach(System.out::println);

	// 		System.out.println("Exemplo Edit");
	// 		cursoRepository.update(
	// 			new Curso((long) 3, "Testando Update", 300));
	// 		listaCursos = cursoRepository.obtainAll();
	// 		listaCursos.forEach(System.out::println);

			// System.out.println("Exemplo Select Por Nome");
			// cursoRepository.obtainForName("an");
			// listaCursos = cursoRepository.obtainForName("an");
			// listaCursos.forEach(System.out::println);

			// System.out.println("Exemplo Delete");
			// cursoRepository.delete(
			// 		listaCursos.get(0)
			// 	);
			// listaCursos = cursoRepository.obtainAll();
			// listaCursos.forEach(System.out::println);

			// System.out.println("Exemplo Delete By ID");
			// cursoRepository.deleteId(4);
			// listaCursos = cursoRepository.obtainAll();
			// listaCursos.forEach(System.out::println);

		// };
	// }

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}

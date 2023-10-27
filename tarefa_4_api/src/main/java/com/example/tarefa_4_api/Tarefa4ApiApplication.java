package com.example.tarefa_4_api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa_4_api.models.Agenda;
import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;
import com.example.tarefa_4_api.repositories.AgendaRepository;
import com.example.tarefa_4_api.repositories.CursosRepository;
import com.example.tarefa_4_api.repositories.ProfessoresRepository;

@SpringBootApplication
public class Tarefa4ApiApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired AgendaRepository agendaRepository,
		@Autowired CursosRepository cursosRepository,
		@Autowired ProfessoresRepository professoresRepository
	){
		return args ->{
			System.out.println("Cadastrar Professor");
			Professores p1 = new Professores(0, "Arnaldo César", "97865948573", "234567894", "Marília", "24567896543");
			Professores p2 = new Professores(0, "Marcelo Alberto", "96783025825", "345678912",  "São Roque", "1574839201");
			Professores p3 = new Professores(0, "Maria Cavalcante", "23456789621", "909674832", "Jundiaí", "35678960021");

			p1 = professoresRepository.save(p1);
			p2 = professoresRepository.save(p2);
			p3 = professoresRepository.save(p3);
			
			List<Professores> listaProfessores = professoresRepository.findAll();

			System.out.println("Cadastrar Curso");
			Cursos c1 = new Cursos(0, "Ortopedia", 3489.0, "Formar profissionais capacitados para prevenir, diagnosticar e tratar disfunções do movimento humano", "Tratamento de lesões musculoesqueléticas, como fraturas, luxações e entorses.");
			Cursos c2 = new Cursos(0, "Neurologia", 5689.0, "Formar profissionais capacitados para prevenir, diagnosticar e tratar disfunções do movimento humano", "tratamento de doenças neurológicas, como AVC, esclerose múltipla e Parkinson.");
			Cursos c3 = new Cursos(0, "Pneumologia", 8789.0, "Formar profissionais capacitados para prevenir, diagnosticar e tratar disfunções do movimento humano", "Tratamento de doenças pulmonares, como asma e bronquite.");
			Cursos c4 = new Cursos(0, "Abordagens Terapêuticas", 8789.0, "Formar profissionais capazes de identificar e tratar problemas.", "Maneiras diferentes de tratar um problema ou condição psicológica.");
			Cursos c5 = new Cursos(0, "Fisioterapia Inicial", 8789.0, "Formar profissionais capazes de identificar e tratar problemas.", "A fisioterapia inicial é o primeiro passo no processo de reabilitação de um paciente.");
			Cursos c6 = new Cursos(0, "Fisioterapia nível I", 8789.0, "Desenvolver habilidades clínicas e teóricas para o diagnóstico e tratamento de problemas físicos, motores ou neurológicos.", "O curso prepara o fisioterapeuta para atuar na prevenção, recuperação e reabilitação de pacientes com problemas físicos, motores ou neurológicos.");
			Cursos c7 = new Cursos(0, "Fisioterapia XYZ", 8789.0, "Formar profissionais prepara o fisioterapeuta para atuar na prevenção, recuperação e reabilitação de pacientes com problemas físicos, motores ou neurológicos.", "A fisioterapia XYZ conta com uma equipe de fisioterapeutas experientes e qualificados, que estão comprometidos em fornecer o melhor atendimento possível aos seus pacientes.");
			
			c1 = cursosRepository.save(c1);
			c2 = cursosRepository.save(c2);
			c3 = cursosRepository.save(c3);
			c4 = cursosRepository.save(c4);
			c5 = cursosRepository.save(c5);
			c6 = cursosRepository.save(c6);
			c7 = cursosRepository.save(c7);

			List<Cursos> listaCursos = cursosRepository.findAll();
			
			System.out.println("Cadastrar Curso");
			
			c5.setProfessores(Arrays.asList(p1));
			c5 = cursosRepository.save(c5);

			c6.setProfessores(Arrays.asList(p1));
			c6 = cursosRepository.save(c6);

			c5.setProfessores(Arrays.asList(p2));
			c5 = cursosRepository.save(c5);

			c4.setProfessores(Arrays.asList(p3));
			c4 = cursosRepository.save(c4);

			listaCursos = cursosRepository.findAll();
			listaCursos.forEach(System.out::println);
			
			listaProfessores = professoresRepository.findAll();
			listaProfessores.forEach(System.out::println);
			
			System.out.println("Ver Cursos Cadastrados P1");
			System.out.println(p1.getCursos());

			System.out.println("Cadastrar Agenda");
			Agenda ag1 = new Agenda(0, LocalDate.now(), LocalDate.now(), "14:00h", "14:30h", "Mairinque", "SP", "18120970", p1.getId(), c5.getId());
			Agenda ag2 = new Agenda(0, LocalDate.now(), LocalDate.now(), "19:00h", "19:30h", "São Paulo", "SP", "01441000", p1.getId(), c6.getId());
			Agenda ag3 = new Agenda(0, LocalDate.now(), LocalDate.now(), "17:00h", "17:40h", "Itu", "SP", "13307149", p2.getId(), c5.getId());
			Agenda ag4 = new Agenda(0, LocalDate.now(), LocalDate.now(), "12:00h", "12:50h", "Boituva", "SP", "18555526", p3.getId(), c4.getId());

			ag1 = agendaRepository.save(ag1);
			ag2 = agendaRepository.save(ag2);
			ag3 = agendaRepository.save(ag3);
			ag4 = agendaRepository.save(ag4);

			List<Agenda> listaAgendas = agendaRepository.findAll();
			listaAgendas.forEach(System.out::println);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Tarefa4ApiApplication.class, args);
	}

}

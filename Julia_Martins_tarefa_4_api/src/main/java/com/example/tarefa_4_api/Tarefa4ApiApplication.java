package com.example.tarefa_4_api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa_4_api.dtos.DadosCursosDTO;
import com.example.tarefa_4_api.models.Agenda;
import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;
import com.example.tarefa_4_api.repositories.AgendaRepository;
import com.example.tarefa_4_api.repositories.CursosRepository;
import com.example.tarefa_4_api.repositories.ProfessoresRepository;
import com.example.tarefa_4_api.services.CursosService;
import com.example.tarefa_4_api.services.ProfessoresService;

@SpringBootApplication
public class Tarefa4ApiApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired AgendaRepository agendaRepository,
		@Autowired CursosRepository cursosRepository,
		@Autowired ProfessoresRepository professoresRepository,
		@Autowired CursosService cursosService,
		@Autowired ProfessoresService professoresService
	){
		return args ->{
			Professores p1 = new Professores(0, "Arnaldo César", "97865948573", "234567894", "Marília", "24567896543");
			Professores p2 = new Professores(0, "Marcelo Alberto", "96783025825", "345678912",  "São Roque", "1574839201");
			Professores p3 = new Professores(0, "Maria Cavalcante", "23456789621", "909674832", "Jundiaí", "35678960021");

			p1 = professoresRepository.save(p1);
			p2 = professoresRepository.save(p2);
			p3 = professoresRepository.save(p3);
			
			professoresRepository.findAll();

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

			cursosRepository.findAll();

			Cursos cursos = cursosRepository.findById(5).orElseThrow();
			Professores professores = professoresRepository.findById(1).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(6).orElseThrow();
			professores = professoresRepository.findById(1).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(5).orElseThrow();
			professores = professoresRepository.findById(2).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(4).orElseThrow();
			professores = professoresRepository.findById(3).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursosRepository.findAll();
			professoresRepository.findAll();

			System.out.println("\nCursos encontrados pelo ID \n");
			DadosCursosDTO c = cursosService.obtainById(4);
			System.out.println(c);

			Agenda ag1 = new Agenda(0, LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-03"), "8:00", "17:00", "Mairinque", "SP", "18120970");
			Agenda ag2 = new Agenda(0, LocalDate.parse("2022-03-17"), LocalDate.parse("2022-03-19"), "8:00", "17:00", "São Paulo", "SP", "01441000");
			Agenda ag3 = new Agenda(0, LocalDate.parse("2022-03-19"), LocalDate.parse("2022-03-21"), "8:00", "12:00", "Itu", "SP", "13307149");
			Agenda ag4 = new Agenda(0, LocalDate.parse("2022-03-21"), LocalDate.parse("2022-03-22"), "8:00", "18:00", "Boituva", "SP", "18555526");

			ag1 = agendaRepository.save(ag1);
			ag2 = agendaRepository.save(ag2);
			ag3 = agendaRepository.save(ag3);
			ag4 = agendaRepository.save(ag4);

			List<Agenda> listaAgendas = agendaRepository.findAll();
			
			listaAgendas.get(0).setCursos(c5);
			listaAgendas.get(0).setProfessores(p1);
			agendaRepository.save(listaAgendas.get(0));

			listaAgendas.get(1).setCursos(c6);
			listaAgendas.get(1).setProfessores(p1);
			agendaRepository.save(listaAgendas.get(1));

			listaAgendas.get(2).setCursos(c5);
			listaAgendas.get(2).setProfessores(p2);
			agendaRepository.save(listaAgendas.get(2));

			listaAgendas.get(3).setCursos(c4);
			listaAgendas.get(3).setProfessores(p3);
			agendaRepository.save(listaAgendas.get(3));

			listaAgendas.forEach(System.out::println);

			System.out.println("\n ** Agenda de Professores ** \n");
			List<Professores> p = professoresRepository.findProfessoresFetchAgenda(1);
			System.out.println(p);

			System.out.println("\n ** Agenda de Professores ** \n");
			List<Agenda> a = agendaRepository.findAgendaByIdProfessoresFetchProfessores(1);
			System.out.println(a);

			System.out.println("\n ** Professor Está com Agenda na Data Determinada ** \n");
			Agenda a1 = agendaRepository.findAgendaFetchDataInicioProfessores(LocalDate.parse("2022-01-01"), 1);
			System.out.println(a1);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Tarefa4ApiApplication.class, args);
	}

}

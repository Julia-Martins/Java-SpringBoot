package com.example.tarefa_4_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa_4_api.dtos.CursosDTO;
import com.example.tarefa_4_api.dtos.DadosCursosDTO;
import com.example.tarefa_4_api.services.CursosService;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {
    private CursosService cursosService;

    public CursosController(CursosService cursosService){
        this.cursosService = cursosService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int salvarCurso(@RequestBody CursosDTO cursosDTO){
        return cursosService.salvarCurso(cursosDTO).getId();
    }

    @GetMapping
    public List<CursosDTO> listarCursos(){
        return cursosService.listarCursos();
    }

    @GetMapping("{id}")
    public DadosCursosDTO getById(@PathVariable Integer id){
        return cursosService.obtainById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        cursosService.delete(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody CursosDTO dto){
        cursosService.update(id, dto);
    }
}

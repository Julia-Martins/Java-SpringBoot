package com.example.aula_3.controllers;

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

import com.example.aula_3.dtos.CursoDTO;
import com.example.aula_3.dtos.DadosCursoDTO;
import com.example.aula_3.services.CursoService;


@RestController
@RequestMapping("/api/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int insert(@RequestBody CursoDTO cursoDTO){
        return cursoService.salvar(cursoDTO).getId();
    }

    @GetMapping
    public List<CursoDTO> listarTodos(){
        return cursoService.listarTodos();
    }

    @GetMapping("{id}")
    public DadosCursoDTO getById(@PathVariable Integer id) {
        return cursoService.obterPorId(id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        cursoService.excluir(id);
    }
    
    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody CursoDTO dto) {        
        cursoService.editar(id, dto);
    }
}

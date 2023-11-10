package com.example.tarefa_4_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa_4_api.dtos.DadosProfessoresDTO;
import com.example.tarefa_4_api.dtos.ProfessoresDTO;
import com.example.tarefa_4_api.services.ProfessoresService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/professores")
public class ProfessoresController {
    private ProfessoresService professoresService;

    public ProfessoresController(ProfessoresService professoresService){
        this.professoresService = professoresService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int insert(@RequestBody ProfessoresDTO professoresDTO) {
        return professoresService.salvar(professoresDTO).getId();
    }

    @GetMapping
    public List<ProfessoresDTO> listarTodos(){
        return professoresService.listarTodos();
    }

    @GetMapping("{id}")
    public DadosProfessoresDTO getById(@PathVariable Integer id){
        return professoresService.obtainById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        professoresService.delete(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody ProfessoresDTO dto){
        professoresService.update(id, dto);
    }
    

}

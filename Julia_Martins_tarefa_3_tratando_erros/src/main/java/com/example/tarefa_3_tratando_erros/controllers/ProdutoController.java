package com.example.tarefa_3_tratando_erros.controllers;

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

import com.example.tarefa_3_tratando_erros.dtos.DadosProdutoDTO;
import com.example.tarefa_3_tratando_erros.dtos.ProdutoDTO;
import com.example.tarefa_3_tratando_erros.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int insert(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.salvar(produtoDTO).getId();
    }

    @GetMapping
    public List<ProdutoDTO> listarTodos(){
        return produtoService.listAll();
    }

    @GetMapping("{id}")
    public DadosProdutoDTO getById(@PathVariable Integer id){
        return produtoService.obtainById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        produtoService.delete(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody ProdutoDTO dto){
        produtoService.update(id, dto);
    }
}

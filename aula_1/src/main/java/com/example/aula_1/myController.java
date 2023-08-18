package com.example.aula_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula_1.models.NumeroDTO;

@RestController
public class myController {
    @GetMapping(value = "/")
    public String getHelloWorld(){
        return "Hello World !!!";
    }   

    @GetMapping(value = "/animal")
    public String getAnimal(
        @RequestParam(name = "p1") String p1,
        @RequestParam(name = "p2") String p2){
        return "Wolf " + p1 + " e " + p2;
    }
    
    @GetMapping(value = "/animals/{p1}/{p2}")
    public String getAnimals(
        @PathVariable(name = "p1") String p1,
        @PathVariable(name = "p2") String p2){
        return p1 + " e " + p2;
    }
    
    @PostMapping(value = "objectExample")
    public NumeroDTO postExempla(
        @RequestBody() NumeroDTO numeroDTO
    ){
        return numeroDTO;
    }
}
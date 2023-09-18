package com.example.aula_2.models;

public class User {
    private Integer cod;
    
    private String name;

    public User(){}

    public User(Integer cod, String name){
        this.cod  = cod;
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }
    public void setCod(Integer cod) {
        this.cod = cod;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

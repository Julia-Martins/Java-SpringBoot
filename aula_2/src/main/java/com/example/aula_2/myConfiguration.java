package com.example.aula_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfiguration {

    @Bean
    public String nameApplication(){
        return "Class Project 2";
    }

    @Bean
    public String versionApplication(){
        return "1.0";
    }
}

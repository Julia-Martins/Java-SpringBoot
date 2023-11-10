package com.example.tarefa_4_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.tarefa_4_api.dtos.ApiErrorDTO;
import com.example.tarefa_4_api.exceptions.RegraNegocioException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationAControllerAdvice {
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrorDTO handleRegraNegocioException(RegraNegocioException ex){
        String msg = ex.getMessage();
        return new ApiErrorDTO(msg);
    }
}

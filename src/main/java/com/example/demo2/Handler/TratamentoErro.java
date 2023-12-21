package com.example.demo2.Handler;


  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo2.model.Erro;
import com.example.demo2.model.Tratamentos.ResourceBadRequestException;
import com.example.demo2.model.Tratamentos.ResourceNotFoundException;




@ControllerAdvice
public class TratamentoErro {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){

        Erro erro = new Erro("Not Found", ex.getMessage(), 404);
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex){

        Erro erro = new Erro("Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerResourceException(Exception ex){

        Erro erro = new Erro("Internal Server Error", ex.getMessage(), 500);
        return ResponseEntity.status(500).body(erro);
    }
}


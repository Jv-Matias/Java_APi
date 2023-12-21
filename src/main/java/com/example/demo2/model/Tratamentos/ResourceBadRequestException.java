package com.example.demo2.model.Tratamentos;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException (String mensagem){
        super(mensagem);
    }
}

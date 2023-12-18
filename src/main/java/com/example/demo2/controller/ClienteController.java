package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.cliente;
import com.example.demo2.service.ClienteService;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
  
    
    @GetMapping
    public List<cliente> obtertodos(){
        
        return clienteService.obtertodos();
    }


    @GetMapping("/{id}")
    public cliente obterPorId(@PathVariable Long id){

        return clienteService.obterPorId(id);

    }


   @PostMapping 
public cliente Cadastrar(@RequestBody cliente cliente){

    return clienteService.Cadastrar(cliente);
}


   @PutMapping ("/{id}")
public cliente Atualizar(@PathVariable Long id, @RequestBody cliente cliente){

    return clienteService.Atualizar(id, cliente);
}

@DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
    clienteService.Deletar(id);

}

}

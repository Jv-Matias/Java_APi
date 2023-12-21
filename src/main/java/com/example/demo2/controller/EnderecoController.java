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

import com.example.demo2.model.Endereco;
import com.example.demo2.service.EnderecoService;

@RestController
@RequestMapping("api/endereco")
@CrossOrigin("*")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
  
    
    @GetMapping
    public List <Endereco> obtertodos(){
        
        return enderecoService.obtertodos();
    }


    @GetMapping("/{id}")
    public Endereco obterPorId(@PathVariable Long id){

        return enderecoService.obterPorId(id);

    }


   @PostMapping 
public Endereco Cadastrar(@RequestBody Endereco endereco){

    return enderecoService.Cadastrar(endereco);
}


   @PutMapping ("/{id}")
public Endereco Atualizar(@PathVariable Long id, @RequestBody Endereco endereco){

    return enderecoService.Atualizar(id, endereco);
}

@DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
  enderecoService.Deletar(id);

}
}

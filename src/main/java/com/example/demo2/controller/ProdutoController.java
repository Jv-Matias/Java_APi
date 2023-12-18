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

import com.example.demo2.model.produto;
import com.example.demo2.service.ProdutoService;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
  
    
    @GetMapping
    public List <produto> obtertodos(){
        
        return produtoService.obtertodos();
    }


    @GetMapping("/{id}")
    public produto obterPorId(@PathVariable Long id){

        return produtoService.obterPorId(id);

    }


   @PostMapping 
public produto Cadastrar(@RequestBody produto produto){

    return produtoService.Cadastrar(produto);
}


   @PutMapping ("/{id}")
public produto Atualizar(@PathVariable Long id, @RequestBody produto produto){

    return produtoService.Atualizar(id, produto);
}

@DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
  produtoService.Deletar(id);

}
}

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

import com.example.demo2.model.Usuario;
import com.example.demo2.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
  
    
    @GetMapping
    public List<Usuario> obtertodos(){
        
        return usuarioService.obtertodos();
    }


    @GetMapping("/{id}")
    public Usuario obterPorId(@PathVariable Long id){

        return usuarioService.obterPorId(id);

    }


   @PostMapping 
public Usuario Cadastrar(@RequestBody Usuario usuario){

    return usuarioService.Cadastrar(usuario);
}


   @PutMapping ("/{id}")
public Usuario Atualizar(@PathVariable Long id, @RequestBody Usuario usuario){

    return usuarioService.Atualizar(id, usuario);
}

@DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
    usuarioService.Deletar(id);

}

}

package com.example.demo2.controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo2.model.Familia;
import com.example.demo2.model.Mercadoria;
import com.example.demo2.service.FamiliaService;

@RestController
@RequestMapping("api/familia")
@CrossOrigin("*")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping
    public List<Familia> obterTodos() {
        return familiaService.obtertodos();
    }

    @GetMapping("/{id}")
    public Familia obterPorId(@PathVariable Long id) {
        return familiaService.obterPorId(id);
    }

    @PostMapping
    public Familia cadastrar(@RequestBody Familia familia) {
        return familiaService.Cadastrar(familia);
    }

    @PutMapping("/adicionar-a-familia/{mercadoriaId}/{familiaId}")
    public ResponseEntity<Void> adicionarMercadoriaAFamilia(
            @PathVariable Long mercadoriaId,
            @PathVariable Long familiaId) {
        
        familiaService.adicionarMercadoriaAFamilia(mercadoriaId, familiaId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        familiaService.Deletar(id);
    }

     @GetMapping("/{id}/mercadorias")
    public List<Mercadoria> obterMercadoriasDaFamilia(@PathVariable Long id){
        return familiaService.obterMercadoriasDaFamilia(id);
    }
}




package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo2.model.Mercadoria;
import com.example.demo2.service.MercadoriaService;

@RestController
@RequestMapping("api/mercadoria")
@CrossOrigin("*")
public class MercadoriaController {

    @Autowired
    private MercadoriaService mercadoriaService;

    @GetMapping
    public List<Mercadoria> obterTodos() {
        return mercadoriaService.obterTodos();
    }

    @GetMapping("/{id}")
    public Mercadoria obterPorId(@PathVariable Long id) {
        return mercadoriaService.obterPorId(id);
    }

    @PostMapping
    public Mercadoria cadastrar(@RequestBody Mercadoria mercadoria) {
        return mercadoriaService.cadastrar(mercadoria);
    }

    @PutMapping("/{id}")
    public Mercadoria atualizar(@PathVariable Long id, @RequestBody Mercadoria mercadoria) {
        return mercadoriaService.atualizar(id, mercadoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        mercadoriaService.deletar(id);
    }

    @PostMapping("/{mercadoriaId}/familia/{familiaId}")
    public void adicionarMercadoriaAFamilia(@PathVariable Long mercadoriaId, @PathVariable Long familiaId) {
        mercadoriaService.adicionarMercadoriaAFamilia(mercadoriaId, familiaId);
    }
}

package com.example.demo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.model.Familia;
import com.example.demo2.model.Mercadoria;
import com.example.demo2.model.Tratamentos.ResourceNotFoundException;
import com.example.demo2.repository.FamiliaRepository;
import com.example.demo2.repository.MercadoriaRepository;

@Service
public class MercadoriaService {

    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    @Autowired
    private FamiliaRepository familiaRepository;

    public Mercadoria cadastrar(Mercadoria mercadoria) {
        return mercadoriaRepository.save(mercadoria);
    }

    public List<Mercadoria> obterTodos() {
        return mercadoriaRepository.findAll();
    }

    public Mercadoria obterPorId(Long id) {
        Optional<Mercadoria> optMercadoria = mercadoriaRepository.findById(id);
        if (optMercadoria.isEmpty()) {
            throw new ResourceNotFoundException("Não existe uma mercadoria com o ID " + id);
        }

        return optMercadoria.get();
    }

    public Mercadoria atualizar(Long id, Mercadoria mercadoria) {
        mercadoria.setId(id);
        return mercadoriaRepository.save(mercadoria);
    }

    public void deletar(Long id) {
        mercadoriaRepository.deleteById(id);
    }

    public void adicionarMercadoriaAFamilia(Long mercadoriaId, Long familiaId) {
        Mercadoria mercadoria = mercadoriaRepository.findById(mercadoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Mercadoria não encontrada com o ID " + mercadoriaId));

        Familia familia = familiaRepository.findById(familiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Família não encontrada com o ID " + familiaId));

        mercadoria.setFamilia(familia);
        mercadoriaRepository.save(mercadoria);
    }
}

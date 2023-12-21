

package com.example.demo2.service;


import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


import com.example.demo2.model.Familia;
import com.example.demo2.model.Mercadoria;
import com.example.demo2.model.Tratamentos.ResourceNotFoundException;
import com.example.demo2.repository.FamiliaRepository;

@Service
public class FamiliaService {
    
    @Autowired
    private FamiliaRepository familiaRepository;

    public Familia Cadastrar( Familia familia){
        return familiaRepository.save(familia);
    }

    public List<Familia> obtertodos(){
        return familiaRepository.findAll();
    }

    public Familia obterPorId(Long id){
        Optional<Familia> optfamilias = familiaRepository.findById(id);
        if(optfamilias.isEmpty()){
            throw new ResourceNotFoundException("Não existe um tipo com o ID " + id);
        }

        return optfamilias.get();
    }

        public Familia Atualizar(Long id, Familia familia){
        


            familia.setId(id);

            return familiaRepository.save(familia);
    }


    
    public void Deletar(Long id){
       familiaRepository.deleteById(id);
    }

    public void adicionarMercadoriaAFamilia(Long mercadoriaId, Long familiaId) {
    }

    public List<Item> obterItensDaFamilia(Long id) {
        return null;
    }

     public List<Mercadoria> obterMercadoriasDaFamilia(Long familiaId) {
        Familia familia = familiaRepository.findById(familiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Família não encontrada com o ID " + familiaId));

        return familia.getProdutos();
    }

 
    public void adicionarMercadoriaAFamilia(Long mercadoriaId, Long familiaId, CrudRepository<Familia, Long> mercadoriaRepository) {
        Familia mercadoria = mercadoriaRepository.findById(mercadoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Mercadoria não encontrada com o ID " + mercadoriaId));
    
        Familia familia = familiaRepository.findById(familiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Família não encontrada com o ID " + familiaId));
    
        familia.getMercadorias().add(mercadoria);
        familiaRepository.save(familia);
}
}

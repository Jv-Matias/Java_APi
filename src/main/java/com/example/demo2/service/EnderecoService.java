

package com.example.demo2.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo2.model.Endereco;
import com.example.demo2.model.Tratamentos.ResourceNotFoundException;
import com.example.demo2.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco Cadastrar( Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obtertodos(){
        return enderecoRepository.findAll();
    }

    public Endereco obterPorId(Long id){
        Optional<Endereco> optenderecos = enderecoRepository.findById(id);
        if(optenderecos.isEmpty()){
            throw new ResourceNotFoundException("Não existe um tipo com o ID " + id);
        }

        return optenderecos.get();
    }

        public Endereco Atualizar(Long id, Endereco endereco){
        


            endereco.setId(id);

            return enderecoRepository.save(endereco);
    }

    public void Deletar(Long id){
       enderecoRepository.deleteById(id);
    }
}

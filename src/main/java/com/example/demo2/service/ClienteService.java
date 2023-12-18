package com.example.demo2.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.model.cliente;
import com.example.demo2.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public cliente Cadastrar( cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<cliente> obtertodos(){
        return clienteRepository.findAll();
    }

    public cliente obterPorId(Long id){
        Optional<cliente> optcliente = clienteRepository.findById(id);
        if(optcliente.isEmpty()){
            throw new IllegalArgumentException("Não existe um cliente cadastrado com esse ID");
        }

        return optcliente.get();
    }

        public cliente Atualizar(Long id, cliente cliente){
        


            cliente.setId(id);

            return clienteRepository.save(cliente);
    }

    public void Deletar(Long id){
        clienteRepository.deleteById(id);
    }
}

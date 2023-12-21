package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Endereco;


public interface EnderecoRepository extends JpaRepository <Endereco,Long>{
    
}

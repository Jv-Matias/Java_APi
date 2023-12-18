package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.cliente;





public interface ClienteRepository extends JpaRepository <cliente, Long> {
    
    cliente findbyNome(String nome);
}

package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Mercadoria;


public interface MercadoriaRepository extends JpaRepository <Mercadoria,Long>{
    
}

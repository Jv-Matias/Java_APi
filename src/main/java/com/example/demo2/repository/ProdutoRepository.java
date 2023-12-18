package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.produto;

public interface ProdutoRepository extends JpaRepository <produto,Long>{
    
}

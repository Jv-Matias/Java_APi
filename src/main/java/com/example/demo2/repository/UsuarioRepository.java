package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo2.model.Usuario;




public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}
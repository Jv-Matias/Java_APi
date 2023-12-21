package com.example.demo2.model;




import java.util.List;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Familia {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_familia")  
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "familia")
    private List<Mercadoria> mercadorias;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mercadoria> getProdutos() {
        return null;
    }

    public List<Familia> getMercadorias() {
        return null;
    }


}

package com.example.demo2.model;

import com.example.demo2.model.Enum.Ecategorias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class produto {
   
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Column(name = "id_produtos")  
private Long id;

@Column(nullable = false)
private String descricao;

@Column(nullable = false)
private double valor;

@Column(nullable = false)
private Ecategorias categorias;



public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public double getValor() {
    return valor;
}

public void setValor(double valor) {
    this.valor = valor;
}

public Ecategorias getCategorias() {
    return categorias;
}

public void setCategorias(Ecategorias categorias) {
    this.categorias = categorias;
}


}

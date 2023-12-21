package com.example.demo2.model;

public class Erro {
    
    private String titulo;
    private String mensagem;
    private int status;
    
    public Erro(String titulo, String mensagem, int status) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }
}
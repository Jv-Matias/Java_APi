package com.example.demo2.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.model.Usuario;
import com.example.demo2.model.Endereco;
import com.example.demo2.model.Tratamentos.ResourceNotFoundException;
import com.example.demo2.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService; // Certifique-se de ter o serviço de Endereco injetado

    public Usuario Cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtertodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obterPorId(Long id) {
        Optional<Usuario> optusuario = usuarioRepository.findById(id);
        if (optusuario.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um tipo com o ID " + id);
        }

        return optusuario.get();
    }

    public Usuario Atualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void Deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Set<Endereco> obterEnderecosDoUsuario(Long usuarioId) {
        Usuario usuario = obterPorId(usuarioId);
        return usuario.getEnderecos();
    }
}

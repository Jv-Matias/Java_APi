

package com.example.demo2.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo2.model.produto;
import com.example.demo2.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public produto Cadastrar( produto produto){
        return produtoRepository.save(produto);
    }

    public List<produto> obtertodos(){
        return produtoRepository.findAll();
    }

    public produto obterPorId(Long id){
        Optional<produto> optprodutos = produtoRepository.findById(id);
        if(optprodutos.isEmpty()){
            throw new IllegalArgumentException("Não existe um produto cadastrado com esse ID");
        }

        return optprodutos.get();
    }

        public produto Atualizar(Long id, produto produto){
        


            produto.setId(id);

            return produtoRepository.save(produto);
    }

    public void Deletar(Long id){
       produtoRepository.deleteById(id);
    }
}

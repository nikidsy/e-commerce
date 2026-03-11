package com._DM.E_commerce.service;

import com._DM.E_commerce.entity.Produto;
import com._DM.E_commerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criarProduto(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listarProduto(){
        return repository.findAll();
    }

    public Produto buscarProduto(UUID id){
        return repository.findById(id).orElse(null);
    }

    public void deletarProduto(UUID id){
        repository.deleteById(id);
    }
}
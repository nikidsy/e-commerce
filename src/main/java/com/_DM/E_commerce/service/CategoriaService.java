package com._DM.E_commerce.service;

import com._DM.E_commerce.entity.Categoria;
import com._DM.E_commerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria criarCategoria(Categoria categoria){
        return repository.save(categoria);
    }

    public List<Categoria> listarCategoria(){
        return repository.findAll();
    }

    public Categoria buscarCategoria(UUID id){
        return repository.findById(id).orElse(null);
    }
}
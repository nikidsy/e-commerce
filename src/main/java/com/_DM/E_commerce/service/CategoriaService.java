package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.CategoriaDTO;
import com._DM.E_commerce.entity.Categoria;
import com._DM.E_commerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaDTO criarCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        categoria = repository.save(categoria);
        dto.setId(categoria.getId());

        return dto;
    }

    public List<CategoriaDTO> listarCategoria() {
        List<Categoria> categorias = repository.findAll();
        List<CategoriaDTO> lista = new ArrayList<>();

        for (Categoria c : categorias) {
            lista.add(new CategoriaDTO(c.getId(), c.getNome()));
        }

        return lista;
    }
}
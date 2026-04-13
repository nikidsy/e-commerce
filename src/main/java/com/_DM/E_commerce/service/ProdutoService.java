package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.ProdutoDTO;
import com._DM.E_commerce.entity.Categoria;
import com._DM.E_commerce.entity.Produto;
import com._DM.E_commerce.repositories.CategoriaRepository;
import com._DM.E_commerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository,
                          CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO criarProduto(ProdutoDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setImgUrl(dto.getImgUrl());
        produto.setPreco(Double.valueOf(dto.getPreco()));

        Set<Categoria> categorias = new HashSet<>();

        for (UUID catId : dto.getCategoriasIds()) {
            categoriaRepository.findById(catId)
                    .ifPresent(categorias::add);
        }

        produto.setCategorias(categorias);

        produto = produtoRepository.save(produto);

        dto.setId(produto.getId());
        return dto;
    }

    public List<ProdutoDTO> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> lista = new ArrayList<>();

        for (Produto p : produtos) {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setDescricao(p.getDescricao());
            dto.setImgUrl(p.getImgUrl());
            dto.setPreco(String.valueOf(p.getPreco()));

            Set<UUID> catIds = new HashSet<>();
            for (Categoria c : p.getCategorias()) {
                catIds.add(c.getId());
            }

            dto.setCategoriasIds(catIds);
            lista.add(dto);
        }

        return lista;
    }
}
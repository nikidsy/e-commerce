package com._DM.E_commerce.controller;

import com._DM.E_commerce.entity.Produto;
import com._DM.E_commerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return service.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProduto(){
        return service.listarProduto();
    }

    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable UUID id){
        return service.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable UUID id){
        service.deletarProduto(id);
    }
}
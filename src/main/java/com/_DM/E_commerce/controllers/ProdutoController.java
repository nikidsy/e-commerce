package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.ProdutoDTO;
import com._DM.E_commerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
        ProdutoDTO novo = service.criarProduto(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProduto() {
        return ResponseEntity.ok(service.listarProduto());
    }
}
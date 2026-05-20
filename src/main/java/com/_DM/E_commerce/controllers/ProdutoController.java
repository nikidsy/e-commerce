package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.ProdutoDTO;
import com._DM.E_commerce.service.FotoService;
import com._DM.E_commerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;
    private final FotoService fotoService;

    public ProdutoController(
            ProdutoService service,
            FotoService fotoService
    ) {
        this.service = service;
        this.fotoService = fotoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(

            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam String preco,
            @RequestParam MultipartFile foto,
            @RequestParam Set<UUID> categoriasIds

    ) throws IOException {

        String caminhoFoto = fotoService.salvarFoto(foto);

        ProdutoDTO dto = new ProdutoDTO();

        dto.setNome(nome);
        dto.setDescricao(descricao);
        dto.setPreco(preco);
        dto.setFoto(caminhoFoto);
        dto.setCategoriasIds(categoriasIds);

        ProdutoDTO novo = service.criarProduto(dto);

        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProduto() {
        return ResponseEntity.ok(service.listarProduto());
    }
}
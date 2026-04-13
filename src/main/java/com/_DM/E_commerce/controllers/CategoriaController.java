package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.CategoriaDTO;
import com._DM.E_commerce.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO dto) {
        CategoriaDTO nova = service.criarCategoria(dto);
        return ResponseEntity.status(201).body(nova);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategoria() {
        return ResponseEntity.ok(service.listarCategoria());
    }
}

package com._DM.E_commerce.controller;

import com._DM.E_commerce.entity.Categoria;
import com._DM.E_commerce.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public Categoria criarCategoia(@RequestBody Categoria categoria){
        return service.criarCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategoria(){
        return service.listarCategoria();
    }

    @GetMapping("/{id}")
    public Categoria buscarCategoria(@PathVariable UUID id){
        return service.buscarCategoria(id);
    }
}
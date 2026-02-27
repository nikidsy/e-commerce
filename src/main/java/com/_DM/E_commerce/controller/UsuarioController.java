package com._DM.E_commerce.controller;

import com._DM.E_commerce.DTOs.UsuarioDTO;
import com._DM.E_commerce.repositories.UsuarioRepository;
import com._DM.E_commerce.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO dto) {
        return service.criarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscar(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }
}


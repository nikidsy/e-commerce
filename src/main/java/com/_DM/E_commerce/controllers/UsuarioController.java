package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.UsuarioDTO;
import com._DM.E_commerce.repositories.UsuarioRepository;
import com._DM.E_commerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO dto) {
        UsuarioDTO novo = service.criarUsuario(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuario() {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable UUID id) {
        UsuarioDTO dto = service.buscarPorId(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }
}

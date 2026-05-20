package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.UsuarioDTO;
import com._DM.E_commerce.service.FotoService;
import com._DM.E_commerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final FotoService fotoService;

    public UsuarioController(
            UsuarioService usuarioService,
            FotoService fotoService
    ) {
        this.usuarioService = usuarioService;
        this.fotoService = fotoService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(

            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam MultipartFile foto

    ) throws IOException {

        String caminhoFoto = fotoService.salvarFoto(foto);

        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(nome);
        dto.setEmail(email);
        dto.setSenha(senha);
        dto.setFoto(caminhoFoto);

        UsuarioDTO novo = usuarioService.criarUsuario(dto);

        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuario() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable UUID id) {

        UsuarioDTO dto = usuarioService.buscarPorId(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }
}
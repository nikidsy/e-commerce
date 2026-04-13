package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.PagamentoDTO;
import com._DM.E_commerce.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> criarPagamento(@RequestBody PagamentoDTO dto) {
        PagamentoDTO novo = service.criarPagamento(dto);

        if (novo == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(201).body(novo);
    }
}
package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.PedidoDTO;
import com._DM.E_commerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO dto) {
        PedidoDTO novo = service.criarPedido(dto);

        if (novo == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedido() {
        return ResponseEntity.ok(service.listarPedidos());
    }
}
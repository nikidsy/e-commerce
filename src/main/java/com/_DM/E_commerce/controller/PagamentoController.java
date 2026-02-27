package com._DM.E_commerce.controller;

import com._DM.E_commerce.DTOs.PagamentoDTO;
import com._DM.E_commerce.entity.Pagamento;
import com._DM.E_commerce.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/pagar")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }


    @PostMapping("/{pedidoId}")
    public ResponseEntity<Pagamento> pagar(@PathVariable UUID pedidoId) {
        Pagamento pagamento = service.pagarPedido(pedidoId);
        return ResponseEntity.ok(pagamento);
    }
}

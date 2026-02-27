package com._DM.E_commerce.controller;

import com._DM.E_commerce.DTOs.PedidoDTO;
import com._DM.E_commerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public  PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoDTO criar(@RequestBody PedidoDTO dto) {
        return service.criarPedido(dto);
    }

    @GetMapping
    public List<PedidoDTO> listar(){
        return service.listarPedidos();
    }

}

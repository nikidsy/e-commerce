package com._DM.E_commerce.controllers;

import com._DM.E_commerce.DTOs.ItemDoPedidoDTO;
import com._DM.E_commerce.service.ItemDoPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens")
public class ItemDoPedidoController {

    private final ItemDoPedidoService service;

    public ItemDoPedidoController(ItemDoPedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ItemDoPedidoDTO> criarItem(@RequestBody ItemDoPedidoDTO dto) {
        ItemDoPedidoDTO novo = service.criarItem(dto);

        if (novo == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(201).body(novo);
    }
}
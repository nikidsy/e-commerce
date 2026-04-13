package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.ItemDoPedidoDTO;
import com._DM.E_commerce.entity.*;
import com._DM.E_commerce.repositories.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemDoPedidoService {

    private final ItemDoPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemDoPedidoService(ItemDoPedidoRepository repository,
                               PedidoRepository pedidoRepository,
                               ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public ItemDoPedidoDTO criarItem(ItemDoPedidoDTO dto) {

        Optional<Pedido> pedidoOpt = pedidoRepository.findById(dto.getPedidoId());
        Optional<Produto> produtoOpt = produtoRepository.findById(dto.getProdutoId());

        if (pedidoOpt.isEmpty() || produtoOpt.isEmpty()) return null;

        ItemDoPedido item = new ItemDoPedido(
                pedidoOpt.get(),
                produtoOpt.get(),
                dto.getQuantidade(),
                dto.getPreco()
        );

        repository.save(item);

        return dto;
    }
}
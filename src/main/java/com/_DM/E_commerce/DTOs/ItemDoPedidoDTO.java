package com._DM.E_commerce.DTOs;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoDTO {
    private UUID pedidoId;
    private UUID produtoId;
    private Integer quantidade;
    private Double preco;
}
package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.entity.ItemDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoDTO {

    private UUID pedido_id;
    private UUID produto_id;
    private Integer quantidade;
    private Double preco;

    @Override
    public String toString() {
        return "ItemDoPedidoDTO{" +
                "pedido_id=" + pedido_id +
                ", produto_id=" + produto_id +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
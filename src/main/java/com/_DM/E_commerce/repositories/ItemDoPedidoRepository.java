package com._DM.E_commerce.repositories;

import com._DM.E_commerce.entity.ItemDoPedido;
import com._DM.E_commerce.entity.ItemDoPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK> {
}
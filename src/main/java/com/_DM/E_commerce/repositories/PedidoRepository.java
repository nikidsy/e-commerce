package com._DM.E_commerce.repositories;

import com._DM.E_commerce.entity.Pedido;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findById(@NotBlank(message = "O ID do pedido não pode ser vazio.") UUID pedidoId);

    void deleteById(UUID id);
}

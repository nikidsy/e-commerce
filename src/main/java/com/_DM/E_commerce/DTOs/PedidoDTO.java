package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private UUID id;
    private LocalDate momento;
    private StatusDoPedido status;
    private UUID clienteId;
}
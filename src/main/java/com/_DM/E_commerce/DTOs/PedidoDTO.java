package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.enums.StatusDoPedido;

import java.time.LocalDate;
import java.util.UUID;

public class PedidoDTO {
    private UUID id;
    private LocalDate momento;
    private StatusDoPedido status;
    private UUID clienteId;

    public PedidoDTO() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDate getMomento() { return momento; }
    public void setMomento(LocalDate momento) { this.momento = momento; }

    public StatusDoPedido getStatus() { return status; }
    public void setStatus(StatusDoPedido status) { this.status = status; }

    public UUID getClienteId() { return clienteId; }
    public void setClienteId(UUID clienteId) { this.clienteId = clienteId; }
}
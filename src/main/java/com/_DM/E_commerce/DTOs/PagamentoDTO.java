package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.enums.StatusDoPedido;

import java.time.LocalDate;
import java.util.UUID;

public class PagamentoDTO {
    private UUID id;
    private LocalDate moment;
    private UUID pedidoId;

    public PagamentoDTO() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDate getMoment() { return moment; }
    public void setMoment(LocalDate moment) { this.moment = moment; }

    public UUID getPedidoId() { return pedidoId; }
    public void setPedidoId(UUID pedidoId) { this.pedidoId = pedidoId; }
}

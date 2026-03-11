package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.entity.Pagamento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private UUID id;
    private LocalDate momento;
    private UUID pedidoId;

    public PagamentoDTO(Pagamento pagamento){
        this.id = pagamento.getId();
        this.momento = pagamento.getMomento();
        this.pedidoId = pagamento.getPedido().getId();
    }
}
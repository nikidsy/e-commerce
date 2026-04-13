package com._DM.E_commerce.DTOs;

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
}
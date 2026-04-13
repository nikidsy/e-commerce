package com._DM.E_commerce.DTOs;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private String imgUrl;
    private String preco;
    private Set<UUID> categoriasIds;
}
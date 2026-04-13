package com._DM.E_commerce.DTOs;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private UUID id;
    private String nome;
}
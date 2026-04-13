package com._DM.E_commerce.repositories;

import com._DM.E_commerce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}

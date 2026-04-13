package com._DM.E_commerce.repositories;

import com._DM.E_commerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findById(UUID id);

    void deleteById(UUID id);
}

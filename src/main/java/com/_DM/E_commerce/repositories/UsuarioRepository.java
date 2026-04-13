package com._DM.E_commerce.repositories;

import com._DM.E_commerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(UUID clienteId);
    Usuario findByEmail(String email);
    void deleteById(UUID id);
}

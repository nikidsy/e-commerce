package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.UsuarioDTO;
import com._DM.E_commerce.entity.Usuario;
import com._DM.E_commerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuario = usuarioRepository.save(usuario);

        dto.setId(usuario.getId());
        return dto;
    }

    public List<UsuarioDTO> listarUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> lista = new ArrayList<>();

        for (Usuario u : usuarios) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(u.getId());
            dto.setNome(u.getNome());
            dto.setEmail(u.getEmail());
            dto.setSenha(u.getSenha());
            lista.add(dto);
        }

        return lista;
    }

    public UsuarioDTO buscarPorId(UUID id) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario u = usuarioOptional.get();

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setSenha(u.getSenha());

        return dto;
    }
}




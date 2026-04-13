package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.PedidoDTO;
import com._DM.E_commerce.entity.Pedido;
import com._DM.E_commerce.entity.Usuario;
import com._DM.E_commerce.entity.enums.StatusDoPedido;
import com._DM.E_commerce.repositories.PedidoRepository;
import com._DM.E_commerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PedidoDTO criarPedido(PedidoDTO dto) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(dto.getClienteId());

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario cliente = usuarioOptional.get();

        Pedido pedido = new Pedido();
        pedido.setMomento(LocalDate.now());
        pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
        pedido.setCliente(cliente);

        pedido = pedidoRepository.save(pedido);

        dto.setId(pedido.getId());
        dto.setMomento(pedido.getMomento());
        dto.setStatus(pedido.getStatus());

        return dto;
    }

    public List<PedidoDTO> listarPedidos() {

        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> lista = new ArrayList<>();

        for (Pedido p : pedidos) {
            PedidoDTO dto = new PedidoDTO();
            dto.setId(p.getId());
            dto.setMomento(p.getMomento());
            dto.setStatus(p.getStatus());
            dto.setClienteId(p.getCliente().getId());
            lista.add(dto);
        }

        return lista;
    }
}





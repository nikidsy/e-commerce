package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.PagamentoDTO;
import com._DM.E_commerce.entity.Pagamento;
import com._DM.E_commerce.entity.Pedido;
import com._DM.E_commerce.enums.StatusDoPedido;
import com._DM.E_commerce.repositories.PagamentoRepository;
import com._DM.E_commerce.repositories.PedidoRepository;
import com._DM.E_commerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoService {

    private final UsuarioRepository usuarioRepository;
    private PagamentoRepository pagamentoRepository;
    private PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PagamentoDTO pagar(UUID pedidoId) {

        Optional<Pedido> pedidoOptional =
                pedidoRepository.findById(pedidoId);

        if (pedidoOptional.isEmpty()) {
            return null;
        }

        Pedido pedido = pedidoOptional.get();

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setMomento(LocalDate.now());

        pagamento = pagamentoRepository.save(pagamento);

        pedido.setStatus(StatusDoPedido.PAGO);
        pedidoRepository.save(pedido);

        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(pagamento.getId());
        dto.setMoment(pagamento.getMomento());
        dto.setPedidoId(pedido.getId());

        return dto;
    }

}
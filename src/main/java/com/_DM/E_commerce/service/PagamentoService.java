package com._DM.E_commerce.service;

import com._DM.E_commerce.DTOs.PagamentoDTO;
import com._DM.E_commerce.entity.Pagamento;
import com._DM.E_commerce.entity.Pedido;
import com._DM.E_commerce.repositories.PagamentoRepository;
import com._DM.E_commerce.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository,
                            PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public PagamentoDTO criarPagamento(PagamentoDTO dto) {

        Optional<Pedido> pedidoOpt = pedidoRepository.findById(dto.getPedidoId());

        if (pedidoOpt.isEmpty()) return null;

        Pedido pedido = pedidoOpt.get();

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setMomento(LocalDate.now());

        pagamento = pagamentoRepository.save(pagamento);

        dto.setId(pagamento.getId());
        dto.setMomento(pagamento.getMomento());

        return dto;
    }
}
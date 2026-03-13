package com._DM.E_commerce.entity;

import com._DM.E_commerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate momento;
    private StatusDoPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemDoPedido> items = new HashSet<>();

    public List<Produto> getItems() {
        return items.stream().map(x ->x.getProduto()).toList();
    }

    public void setItemDoPedidos(Set<ItemDoPedido> items) {
        this.items = items;
    }
}

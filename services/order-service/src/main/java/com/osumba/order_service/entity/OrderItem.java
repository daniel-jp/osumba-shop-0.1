package com.osumba.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id") // Nome correto da coluna
    private Order order; // Corrigindo de "orders" para "order"
}

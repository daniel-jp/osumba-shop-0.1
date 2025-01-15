package com.osumba.shoppingCart.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quality;
    @ManyToOne
    @JoinColumn(name = "shopping_id")
    private ShoppingCart shoppingCart;
}

package com.osumba.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.shoppingCart.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}

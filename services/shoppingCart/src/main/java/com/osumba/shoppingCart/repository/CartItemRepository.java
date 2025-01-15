package com.osumba.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.shoppingCart.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}

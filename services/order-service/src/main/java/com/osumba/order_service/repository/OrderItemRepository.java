package com.osumba.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.order_service.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long orderId);
}

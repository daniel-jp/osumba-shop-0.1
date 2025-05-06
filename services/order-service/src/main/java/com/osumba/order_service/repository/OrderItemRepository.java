package com.osumba.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.order_service.entity.OrderItem;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    List<OrderItem> findAllByOrderId(UUID orderId);
}

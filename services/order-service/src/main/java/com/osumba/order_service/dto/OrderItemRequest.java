package com.osumba.order_service.dto;

import com.osumba.order_service.entity.Order;

public record OrderItemRequest(
        Long id,
        Long orderId,
        int quantity,
        Order order
) {
}

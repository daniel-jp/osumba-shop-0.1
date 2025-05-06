package com.osumba.order_service.dto;

import com.osumba.order_service.entity.Order;

import java.util.UUID;

public record OrderItemRequest(
        UUID id,
        UUID orderId,
        int quantity,
        Order order
) {
}

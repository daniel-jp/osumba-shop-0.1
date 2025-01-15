package com.osumba.order_service.dto;

public record OrderItemRequest(
        Long id,
        Long orderId,
        int quantity
) {
}

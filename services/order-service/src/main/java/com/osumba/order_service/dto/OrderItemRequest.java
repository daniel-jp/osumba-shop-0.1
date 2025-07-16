package com.osumba.order_service.dto;


import java.util.UUID;

public record OrderItemRequest(
        Integer id,
        //UUID productId,
        int quantity,
        UUID orderId) {
}

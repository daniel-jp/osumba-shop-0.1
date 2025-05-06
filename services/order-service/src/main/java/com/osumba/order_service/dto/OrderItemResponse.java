package com.osumba.order_service.dto;

import com.osumba.order_service.entity.Order;

import java.util.UUID;

public record OrderItemResponse(
        UUID id,
        int quantity,
        Order order
) { }

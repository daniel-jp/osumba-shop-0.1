package com.osumba.order_service.dto;

import com.osumba.order_service.entity.Order;

public record OrderItemResponse(
        Long id,
        int quantity,
        Order order
) { }

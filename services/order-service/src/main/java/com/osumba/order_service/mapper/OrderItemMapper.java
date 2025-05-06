package com.osumba.order_service.mapper;

import org.springframework.stereotype.Service;
import com.osumba.order_service.dto.OrderItemRequest;
import com.osumba.order_service.dto.OrderItemResponse;
import com.osumba.order_service.entity.Order;
import com.osumba.order_service.entity.OrderItem;

@Service
public class OrderItemMapper {

    public OrderItem toOrderLine(OrderItemRequest request) {

        return OrderItem.builder()
                .id(request.orderId())
               /* .productId(request.productId()) */
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .order(Order.builder()
                                .id(request.orderId()).build())
                .build();

    }

    public OrderItemResponse toOrderLineResponse(OrderItem orderItem) {
        return new OrderItemResponse(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getOrder()
        );
    }
}

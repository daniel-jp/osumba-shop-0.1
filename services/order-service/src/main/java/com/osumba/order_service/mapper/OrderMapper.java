package com.osumba.order_service.mapper;

import org.springframework.stereotype.Service;
import com.osumba.order_service.dto.OrderRequest;
import com.osumba.order_service.dto.OrderResponse;
import com.osumba.order_service.entity.Order;

@Service
public class OrderMapper {


  public Order toOrder(OrderRequest request) {
    if (request == null) {
      return null;
    }
    return Order.builder()
            .id(request.id())
            .reference(request.reference())
            .orderStatus(request.orderStatus())
            .paymentMethod(request.paymentMethod())

        .build();
  }

  public OrderResponse fromOrder(Order order) {
    return new OrderResponse(
        order.getId(),
        order.getReference(),
        order.getTotalAmount(),
        order.getOrderStatus(),
        order.getPaymentMethod()
    );
  }
}

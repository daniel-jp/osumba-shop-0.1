package com.osumba.order_service.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osumba.order_service.dto.OrderItemResponse;
import com.osumba.order_service.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderItemResponse>> findByOrderId(
            @PathVariable("order-id") Long orderId
    ) {
        return ResponseEntity.ok(orderItemService.findAllByOrderId(orderId));
    }
}

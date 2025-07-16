package com.osumba.order_service.controller;


import com.osumba.order_service.dto.OrderItemRequest;
import com.osumba.order_service.dto.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.osumba.order_service.dto.OrderItemResponse;
import com.osumba.order_service.service.OrderItemService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
public class OrderItemController {


    private final OrderItemService orderItemService;


    // Buscar todos os OrderItems
    @GetMapping
    public ResponseEntity<List<OrderItemResponse>> getAllItem() {
        return ResponseEntity.ok(orderItemService.getAllItems().getBody());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<List<OrderItemResponse>> findByOrderId(@PathVariable("order-id") UUID orderId) {
        return ResponseEntity.ok(orderItemService.findAllByOrderId(orderId));
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody @Valid OrderItemRequest orderItem){
           orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.ok().body("Item created ✅");
    }

}

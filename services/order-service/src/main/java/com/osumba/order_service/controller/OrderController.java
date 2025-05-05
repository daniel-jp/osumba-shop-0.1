package com.osumba.order_service.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osumba.order_service.dto.OrderRequest;
import com.osumba.order_service.dto.OrderResponse;
import com.osumba.order_service.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @PostMapping
  public ResponseEntity<String> createOrder(
      @RequestBody @Valid OrderRequest request) {
    this.service.createOrder(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<OrderResponse>> findAll() {
    return ResponseEntity.ok(this.service.findAllOrders());
  }

  @GetMapping("/{order-id}")
  public ResponseEntity<OrderResponse> findById(@PathVariable("order-id") Long orderId) {
    return ResponseEntity.ok(this.service.findById(orderId));
  }
}

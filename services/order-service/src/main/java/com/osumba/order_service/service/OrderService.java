package com.osumba.order_service.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osumba.order_service.dto.OrderRequest;
import com.osumba.order_service.dto.OrderResponse;

import com.osumba.order_service.mapper.OrderMapper;
import com.osumba.order_service.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private  OrderRepository repository;
    @Autowired
    private  OrderMapper mapper;
    @Autowired
    private  OrderItemService  orderLineService;



    public ResponseEntity<String> createOrder(@Valid OrderRequest request) {
                repository.save(mapper.toOrder(request));
        return ResponseEntity.ok().build();
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}

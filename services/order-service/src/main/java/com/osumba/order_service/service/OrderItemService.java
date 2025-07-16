package com.osumba.order_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osumba.order_service.dto.OrderItemRequest;
import com.osumba.order_service.dto.OrderItemResponse;
import com.osumba.order_service.mapper.OrderItemMapper;
import com.osumba.order_service.repository.OrderItemRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {


    @Autowired
    private  OrderItemRepository orderItemRepository;
    @Autowired
    private  OrderItemMapper mapper;

    public ResponseEntity<UUID> saveOrderItem(OrderItemRequest request) {

        var order = orderItemRepository.save(mapper.toOrderLine(request));
        return ResponseEntity.ok().body(order.getId());
    }

    public List<OrderItemResponse> findAllByOrderId(UUID orderId) {

        return orderItemRepository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }

    public ResponseEntity<List<OrderItemResponse>> getAllItems(){

        return ResponseEntity.ok(orderItemRepository.findAll()
                .stream()
                .map(this.mapper::toOrderLineResponse)
                .collect(Collectors.toList()));
    }

}

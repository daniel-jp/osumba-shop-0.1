package com.osumba.order_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UUID saveOrderLine(OrderItemRequest request) {

        var order = mapper.toOrderLine(request);
        return orderItemRepository.save(order).getId();
    }

    public List<OrderItemResponse> findAllByOrderId(UUID orderId) {

        return orderItemRepository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }

}

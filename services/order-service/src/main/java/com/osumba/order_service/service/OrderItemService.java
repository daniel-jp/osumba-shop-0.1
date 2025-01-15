package com.osumba.order_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.osumba.order_service.dto.OrderItemRequest;
import com.osumba.order_service.dto.OrderItemResponse;
import com.osumba.order_service.mapper.OrderItemMapper;
import com.osumba.order_service.repository.OrderItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper mapper;

    public Long saveOrderLine(OrderItemRequest request) {
        var order = mapper.toOrderLine(request);
        return orderItemRepository.save(order).getId();
    }

    public List<OrderItemResponse> findAllByOrderId(Long orderId) {

        return orderItemRepository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }


}

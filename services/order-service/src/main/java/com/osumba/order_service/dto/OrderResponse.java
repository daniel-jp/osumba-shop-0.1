package com.osumba.order_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.osumba.order_service.enums.OrderStatus;
import com.osumba.order_service.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.UUID;

@JsonInclude(Include.NON_EMPTY)
public record OrderResponse(
    UUID id,
    String reference,
    BigDecimal amount,
    OrderStatus orderStatus,
    PaymentMethod paymentMethod) {

}

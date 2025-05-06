package com.osumba.order_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import com.osumba.order_service.enums.OrderStatus;
import com.osumba.order_service.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@JsonInclude(Include.NON_EMPTY)
public record OrderRequest(
    UUID id,
    String reference,
    @Positive(message = "Order amount should be positive")
    BigDecimal amount,
    @NotNull(message = "Order status method should be precised")
    OrderStatus orderStatus,
    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod) {

}

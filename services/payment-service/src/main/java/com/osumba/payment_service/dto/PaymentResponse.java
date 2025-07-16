package com.osumba.payment_service.dto;

import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponse(
        UUID id,
        BigDecimal amount,
        LocalDateTime createDate,
        LocalDateTime lastModifiedDate,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus
        //  UUID orderId,
        // String orderReference,
        // User user
) {
}

package com.osumba.payment_service.dto;

import lombok.Builder;
import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PaymentRequest(

     UUID id,
     BigDecimal amount,
     LocalDateTime createDate,
     LocalDateTime lastModifiedDate,
     PaymentMethod paymentMethod,
     PaymentStatus paymentStatus
     //UUID orderId,
    // String orderReference,
     //User user
) {
}

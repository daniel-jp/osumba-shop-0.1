package com.osumba.payment_service.dto;

import lombok.Builder;
import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Builder
public record PaymentRequest(

     Long id,
     BigDecimal amount,
     LocalDateTime createDate,
     LocalDateTime lastModifiedDate,
     PaymentMethod paymentMethod,
     PaymentStatus paymentStatus,
     Long orderId,
     String orderReference,
     User user

) {
}

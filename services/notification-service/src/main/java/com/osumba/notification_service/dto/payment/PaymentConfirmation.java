package com.osumba.notification_service.dto.payment;

import com.osumba.notification_service.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String userFirstname,
        String userLastname,
        String userEmail
) {
}

package com.osumba.payment_service.dto;

import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        //String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus

        //String customerFirstname,
        //String customerLastname,
        //String customerEmail
) {
}

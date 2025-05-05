package com.osumba.notification_service.dto.order;

import com.osumba.notification_service.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        User user,
        List<Product> products
) {
}

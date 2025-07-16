package com.osumba.payment_service.mapper;

import com.osumba.payment_service.dto.PaymentResponse;
import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;
import org.springframework.stereotype.Service;
import com.osumba.payment_service.dto.PaymentRequest;
import com.osumba.payment_service.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PaymentMapper {


    public Payment toPayment( PaymentRequest request) {

        return  Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .paymentStatus(request.paymentStatus())
                //.orderId(request.orderId())
                .build();

    }


    public PaymentResponse toPaymentResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getAmount(),
                payment.getCreateDate(),
                payment.getLastModifiedDate(),
                payment.getPaymentMethod(),
                payment.getPaymentStatus()
        );
    }
}

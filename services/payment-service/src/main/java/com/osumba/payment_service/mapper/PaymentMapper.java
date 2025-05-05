package com.osumba.payment_service.mapper;

import org.springframework.stereotype.Service;
import com.osumba.payment_service.dto.PaymentRequest;
import com.osumba.payment_service.entity.Payment;

@Service
public class PaymentMapper {


    public Payment toPayment( PaymentRequest request) {

        return  Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .paymentStatus(request.paymentStatus())
               // .orderId(request.orderId())
                .build();

    }
}

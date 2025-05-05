package com.osumba.payment_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.osumba.payment_service.dto.PaymentNotificationRequest;
import com.osumba.payment_service.dto.PaymentRequest;
import com.osumba.payment_service.mapper.PaymentMapper;
import com.osumba.payment_service.notification.NotificationProducer;
import com.osumba.payment_service.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;


    public Long createPayment( PaymentRequest request) {

        var payment  = paymentRepository.save(paymentMapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.paymentStatus(),
                        request.user().firstName(),
                        request.user().lastName(),
                        request.user().email()
                )
        );
        return payment.getId();
    }
}

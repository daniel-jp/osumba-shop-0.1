package com.osumba.payment_service.service;

import com.osumba.payment_service.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.osumba.payment_service.dto.PaymentNotificationRequest;
import com.osumba.payment_service.dto.PaymentRequest;
import com.osumba.payment_service.mapper.PaymentMapper;
import com.osumba.payment_service.notification.NotificationProducer;
import com.osumba.payment_service.repository.PaymentRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;


    public UUID createPayment(PaymentRequest request) {

        var payment  = paymentRepository.save(paymentMapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        //request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.paymentStatus()
                        //request.createDate(),
                       // request.lastModifiedDate()

                       // request.user().firstName(),
                        //request.user().lastName(),
                        //request.user().email()
                ) );
        return payment.getId();
    }


    public List<PaymentResponse> findAllPayment() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentResponse)
                .collect(Collectors.toList());
    }
}

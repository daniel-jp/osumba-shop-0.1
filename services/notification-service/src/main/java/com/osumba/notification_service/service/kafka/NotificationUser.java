package com.osumba.notification_service.service.kafka;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.osumba.notification_service.dto.order.OrderConfirmation;
import com.osumba.notification_service.dto.payment.PaymentConfirmation;
import com.osumba.notification_service.entity.Notification;
import com.osumba.notification_service.repository.NotificationRepository;
import com.osumba.notification_service.service.email.EmailService;

import java.time.LocalDateTime;

import static java.lang.String.format;
import static com.osumba.notification_service.enums.NotificationType.ORDER_CONFIRMATION;
import static com.osumba.notification_service.enums.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationUser {
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException {

        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var userFullName = paymentConfirmation.userFirstname() + " " + paymentConfirmation.userLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.userEmail(),
                userFullName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotifications(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        var userFullName = orderConfirmation.user().firstname() + " " + orderConfirmation.user().lastname();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.user().email(),
                userFullName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }
}

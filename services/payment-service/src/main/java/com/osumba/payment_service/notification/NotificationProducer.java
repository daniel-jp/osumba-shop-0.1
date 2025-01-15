package com.osumba.payment_service.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.osumba.payment_service.dto.PaymentNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service

public class NotificationProducer {

    private static final Logger log = LoggerFactory.getLogger(NotificationProducer.class);

    private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(PaymentNotificationRequest request) {
        log.info("Sending notification with body = < {} >", request);
        Message<PaymentNotificationRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(TOPIC, "payment-topic")
                .build();

        kafkaTemplate.send(message);
    }
}

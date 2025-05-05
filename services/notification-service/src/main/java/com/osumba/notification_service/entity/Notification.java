package com.osumba.notification_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import com.osumba.notification_service.dto.order.OrderConfirmation;
import com.osumba.notification_service.dto.payment.PaymentConfirmation;
import com.osumba.notification_service.enums.NotificationType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}

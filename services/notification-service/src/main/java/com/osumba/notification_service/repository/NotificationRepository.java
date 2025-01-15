package com.osumba.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.notification_service.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {
}

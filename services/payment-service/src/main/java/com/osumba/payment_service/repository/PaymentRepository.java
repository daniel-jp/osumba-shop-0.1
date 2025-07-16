package com.osumba.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.payment_service.entity.Payment;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}

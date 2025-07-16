package com.osumba.payment_service;

import com.osumba.payment_service.entity.Payment;
import com.osumba.payment_service.enums.PaymentMethod;
import com.osumba.payment_service.enums.PaymentStatus;
import com.osumba.payment_service.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@EnableJpaAuditing
public class PaymentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {}

	@Bean
	CommandLineRunner commandLineRunner(PaymentRepository paymentRepository) {

		return args -> {

			List<Payment> paymentList = List.of(

					Payment.builder()
							.amount(BigDecimal.valueOf(Math.random() * 7000))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.paymentMethod( PaymentMethod.PAYPAL)
							.paymentStatus(PaymentStatus.APPROVED)
							.build(),

					Payment.builder()
							.amount(BigDecimal.valueOf(Math.random() * 9000))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.paymentMethod( PaymentMethod.CREDIT_CARD)
							.paymentStatus(PaymentStatus.PROCESSING)
							.build(),

					Payment.builder()
							.amount(BigDecimal.valueOf(Math.random() * 9000))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.paymentMethod( PaymentMethod.BANK_TRANSFER)
							.paymentStatus(PaymentStatus.PENDING)
							.build());

			paymentRepository.saveAll(paymentList);
		};
	}
}

package com.osumba.order_service;

import com.osumba.order_service.entity.Order;
import com.osumba.order_service.entity.OrderItem;
import com.osumba.order_service.enums.OrderStatus;
import com.osumba.order_service.enums.PaymentMethod;
import com.osumba.order_service.repository.OrderItemRepository;
import com.osumba.order_service.repository.OrderRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class OrderServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}



	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public CommandLineRunner commandLineRunner (OrderRepository orderRepository, OrderItemRepository orderItemRepository){

		return args -> {

			// Criar pedidos sem OrderItems primeiro
			Order order1 = orderRepository.save(
					Order.builder()
							.reference("ord324")
							.totalAmount(BigDecimal.valueOf(Math.random()  * 233))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.orderStatus(OrderStatus.PROCESSING)
							.paymentMethod(PaymentMethod.BANK_TRANSFER)
							.build()
			);

			Order order2 = orderRepository.save(
					Order.builder()
							.reference("ord325")
							.totalAmount(BigDecimal.valueOf(Math.random()  * 433))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.orderStatus(OrderStatus.DELIVERED)
							.paymentMethod(PaymentMethod.VISA)
							.build()
			);

			Order order3 = orderRepository.save(
					Order.builder()
							.reference("ord443")
							.totalAmount(BigDecimal.valueOf(Math.random()  * 433))
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.orderStatus(OrderStatus.CANCELED)
							.paymentMethod(PaymentMethod.MASTER_CARD)
							.build()
			);

			// Criar e associar OrderItems
			OrderItem item1 = OrderItem.builder().quantity(4).order(order1).build();
			OrderItem item2 = OrderItem.builder().quantity(2).order(order1).build();
			OrderItem item3 = OrderItem.builder().quantity(12).order(order2).build();
			OrderItem item4 = OrderItem.builder().quantity(33).order(order2).build();
			OrderItem item5 = OrderItem.builder().quantity(51).order(order3).build();


			orderItemRepository.saveAll(List.of(item1, item2, item3, item4,item5));
		};
	}
}

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

import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (OrderRepository orderRepository, OrderItemRepository orderItemRepository){

		return args -> {

			List<OrderItem> orderItemList=List.of(

					OrderItem.builder().quantity(4).build(),
					OrderItem.builder().quantity(2).build(),
					OrderItem.builder().quantity(12).build(),
					OrderItem.builder().quantity(5).build()


			);
			orderItemRepository.saveAll(orderItemList);


			List<Order> orderList=List.of(

					Order.builder()
							.reference("ord324")
							.totalAmount(Math.random() * 233)
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.orderStatus(OrderStatus.PROCESSING)
							.paymentMethod(PaymentMethod.BANK_TRANSFER)
							.orderItems(List.of(orderItemList.get(1), orderItemList.get(4)))
							.build(),
					Order.builder()
							.reference("ord324")
							.totalAmount(Math.random() * 433)
							.createDate(LocalDateTime.now())
							.lastModifiedDate(LocalDateTime.now())
							.orderStatus(OrderStatus.PROCESSING)
							.paymentMethod(PaymentMethod.BANK_TRANSFER)
							.orderItems(List.of(orderItemList.get(3), orderItemList.get(2)))
							.build()

			);
			orderRepository.saveAll(orderList);

		};

	}

}

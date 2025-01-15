package com.osumba.order_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.osumba.order_service.enums.OrderStatus;
import com.osumba.order_service.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private double totalAmount;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime lastModifiedDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;


    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

}

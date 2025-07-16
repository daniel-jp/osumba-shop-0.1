package com.osumba.card_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int cardNumber;

    @CreatedDate
    //@JsonFormat(pattern = "dd-MM-yyyy")
    @Column(updatable = false, nullable = false)
    private String carHolder ;
    @LastModifiedDate
    @Column(updatable = false, nullable = false)
    private Data expiryDate;

    @Column(updatable = false, nullable = false)
    private int cw;

    // private UUI userId;
   // private UUI orderId;


}

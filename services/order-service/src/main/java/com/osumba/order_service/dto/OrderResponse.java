package com.osumba.order_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.osumba.order_service.enums.OrderStatus;
import com.osumba.order_service.enums.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(Include.NON_EMPTY)
public record OrderResponse(
        UUID id,
        String reference,
        BigDecimal amount,
        OrderStatus orderStatus,
        PaymentMethod paymentMethod,
        @JsonFormat(pattern = "dd/MM/yy HH:mm:ss")

        LocalDateTime createDate,
        @JsonFormat(pattern = "dd/MM/yy HH:mm:ss")
        LocalDateTime lastModifiedDate,
        @JsonFormat(pattern = "dd/MM/yy HH:mm:ss")
        LocalDateTime deliveredDate ) {

}

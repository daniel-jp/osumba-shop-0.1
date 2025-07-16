package com.osumba.card_service.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.UUID;

public record CardResponse(
         UUID id,
         int cardNumber,
         String carHolder,
         Data expiryDate,
         int cw
        //UUI userId,
        //UUI orderId
) {
}

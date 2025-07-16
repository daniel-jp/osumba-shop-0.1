package com.osumba.card_service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record CardRequest(

        UUID id,
        int cardNumber,
        String carHolder,
        Data expiryDate,
        int cw
        // private UUI userId,
) {
}

package com.osumba.product_service.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;


public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        UUID productId,
        @Positive(message = "Quantity is mandatory")
        int quantity

) {
}

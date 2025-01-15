package com.osumba.product_service.dto.productDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public record ProductPurchaseRequests(
        @NotNull(message = "Product is mandatory")
        Long productId,
        @Positive(message = "Quantity is mandatory")
        int quantity

) {
}

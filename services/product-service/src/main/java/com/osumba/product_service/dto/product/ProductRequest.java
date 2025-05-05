package com.osumba.product_service.dto.product;

import com.osumba.product_service.entity.CategoryProd;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public record ProductRequest(
         UUID id,
         String name,
         @NotNull(message = "Product description is required")
         String description,
         int quantityInStock,
         @Positive(message = "Price should be positive")
         BigDecimal price,
         @NotNull(message = "Image is required")
         String imageUrl,
        // @NotNull(message = "Date  create is required")
         Date dataAdded,
         @NotNull(message = "Product category is required")
         CategoryProd category
) {
}

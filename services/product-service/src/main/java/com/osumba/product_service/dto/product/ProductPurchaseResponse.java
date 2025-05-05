package com.osumba.product_service.dto.product;


import java.math.BigDecimal;
import java.util.UUID;

public record ProductPurchaseResponse(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        int quantityInStock){

}

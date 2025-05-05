package com.osumba.product_service.dto.product;


import com.osumba.product_service.entity.CategoryProd;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public record ProductResponse(
        UUID id,
        String name,
        String description,
        int quantityInStock,
        BigDecimal price,
        String imageUrl,
        Date DataAdded,
        CategoryProd category ) {

}

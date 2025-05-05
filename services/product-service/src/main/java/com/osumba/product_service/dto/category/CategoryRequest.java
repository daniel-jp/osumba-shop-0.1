package com.osumba.product_service.dto.category;


import java.util.UUID;

public record CategoryRequest(
         UUID id,
         String name,
         String description) {
}

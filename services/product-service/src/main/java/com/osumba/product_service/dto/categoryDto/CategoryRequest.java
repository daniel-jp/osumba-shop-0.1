package com.osumba.product_service.dto.categoryDto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        Long id,
        @NotNull(message = "Category street is required")
        String street,
        @NotNull(message = "Category immobile number is required")
        String immNumber,
        @NotNull(message = "Category house number  is not a valid")
        String houseNumber,
        @NotNull(message = "Category zipCode is not correct")
        String  zipCode
) {
}

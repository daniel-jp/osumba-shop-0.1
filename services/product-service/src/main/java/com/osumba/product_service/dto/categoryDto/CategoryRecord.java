package com.osumba.product_service.dto.categoryDto;

public record CategoryRecord(
        Long id,
        String street,
        String immNumber,
        String houseNumber,
        String  zipCode ) { }

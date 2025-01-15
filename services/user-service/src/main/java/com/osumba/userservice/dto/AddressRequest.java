package com.osumba.userservice.dto;

import jakarta.validation.constraints.NotNull;

public record AddressRequest(

        Long id,
         @NotNull(message = "Address street is required")
         String street,
         @NotNull(message = "Address immobile number is required")
         String immNumber,
         @NotNull(message = "Address house number  is not a valid")
         String houseNumber,
         @NotNull(message = "Address zipCode is not correct")
         int  zipCode



) {
}

package com.osumba.userservice.dto;

import com.osumba.userservice.entity.User;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddressRequest(

         UUID id,
         @NotNull(message = "Country street is required")
         String country,

         @NotNull(message = "State is required")
         String state,

         @NotNull(message = "City is required")
         String city,

         @NotNull(message = "Address street is required")
         String street,

         @NotNull(message = "Address immobile number is required")
         String immNumber,

         @NotNull(message = "Address house number  is not a valid")
         String houseNumber,

         @NotNull(message = "Address zipCode is not correct")
         int  zipCode,

         @NotNull(message = "User is not correct")
         User user




) {
}

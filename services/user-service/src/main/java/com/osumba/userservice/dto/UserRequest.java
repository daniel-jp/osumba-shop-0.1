package com.osumba.userservice.dto;

import com.osumba.userservice.entity.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserRequest(
         Long id,
         @NotNull(message = "User firstName is required")
         String firstName,
         @NotNull(message = "User lastName is required")
         String lastName,
         @NotNull(message = "User email is not a valid")
         String email,
         @NotNull(message = "User password is not correct")
         String password,
         Address address) {
}

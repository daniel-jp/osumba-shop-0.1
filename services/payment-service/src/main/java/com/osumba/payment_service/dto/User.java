package com.osumba.payment_service.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record User(

         UUID id,
         @NotNull(message = "FirstName is required")
         String firstName,
         @NotNull(message = "LastName is required")
         String lastName,
         @NotNull(message = "Email is required")
         @NotNull(message = "The  user is not currently formatted")
         String email


) {
}

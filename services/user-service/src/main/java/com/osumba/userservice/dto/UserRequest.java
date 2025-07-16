package com.osumba.userservice.dto;

import com.osumba.userservice.entity.Address;
import com.osumba.userservice.enumer.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Builder
public record UserRequest(
         UUID id,
         @NotNull(message = "User firstName is required")
         String firstName,
         @NotNull(message = "User lastName is required")
         String lastName,
         @NotNull(message = "User email is not a valid")
         String email,
         @NotNull(message = "User password is not correct")
         String password,
         @NotNull(message = "User birth day is not correct")
         Date birthDay,
         @NotNull(message = "Set User Role")
         UserRole userRole,
         @NotNull(message = " User is not actived")
         boolean isActive

) {
}

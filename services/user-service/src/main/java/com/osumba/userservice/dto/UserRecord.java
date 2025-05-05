package com.osumba.userservice.dto;

import com.osumba.userservice.entity.Address;
import com.osumba.userservice.enumer.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;


@Builder

public record UserRecord(
         UUID id,
         String firstName,
         String lastName,
         String email,
         String password,
         Date birthDay,
         UserRole userRole,
         boolean isActive

) {
}

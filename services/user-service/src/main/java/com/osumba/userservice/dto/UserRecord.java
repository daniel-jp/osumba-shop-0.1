package com.osumba.userservice.dto;

import com.osumba.userservice.entity.Address;
import lombok.Builder;


@Builder

public record UserRecord(
         Long id,
         String firstName,
         String lastName,
         String email,
         String password,
         Address address  ) {
}

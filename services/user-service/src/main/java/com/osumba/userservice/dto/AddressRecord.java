package com.osumba.userservice.dto;

import com.osumba.userservice.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AddressRecord(
         UUID id,
         String country,
         String state,
         String city,

         String street,
         String immNumber,
         String houseNumber,
         int  zipCode,
         User user){
}

package com.osumba.userservice.dto;

import lombok.Builder;

@Builder
public record AddressRecord(
         Long id,
         String street,
         String immNumber,
         String houseNumber,
         int  zipCode){
}

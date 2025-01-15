package com.osumba.userservice.mapper;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public Address toAddress(AddressRequest request) {
        if (request == null){
            return null;
        }

        return Address.builder()
                .id(request.id())
                .street(request.street())
                .immNumber(request.immNumber())
                .houseNumber(request.houseNumber())
                .zipCode(request.zipCode())
                .build();
    }

    public AddressRecord fromAddress(Address address) {

        return new AddressRecord(
                address.getId(),
                address.getStreet(),
                address.getImmNumber(),
                address.getHouseNumber(),
                address.getZipCode()
        );
    }


}

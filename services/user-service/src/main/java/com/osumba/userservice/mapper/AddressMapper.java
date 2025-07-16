package com.osumba.userservice.mapper;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import com.osumba.userservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public Address toAddress(AddressRequest request) {
        if (request == null){
            return null;
        }

        return Address.builder()
                .id(request.id())
                .country(request.country())
                .state(request.state())
                .city(request.city())
                .street(request.street())
                .immNumber(request.immNumber())
                .houseNumber(request.houseNumber())
                .zipCode(request.zipCode())
                .user(request.user())
                .build();
    }

    public AddressRecord fromAddress(Address address) {

        return new AddressRecord(
                address.getId(),
                address.getCountry(),
                address.getState(),
                address.getCity(),
                address.getStreet(),
                address.getImmNumber(),
                address.getHouseNumber(),
                address.getZipCode(),
                address.getUser()
        );
    }


}

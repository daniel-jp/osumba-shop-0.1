package com.osumba.userservice.service.implementService;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

public interface ImpAddress {

    UUID createAddress(AddressRequest request) ;

    Address updateAddress(UUID addressId, AddressRequest request) ;

    void mergerAddress(Address address, AddressRequest request) ;

    List<AddressRecord> findAllAddress();

    Boolean existsById(UUID addressId);

    AddressRecord findAddressById(UUID addressId) ;

    public void deleteAddressById(UUID addressId) ;
}

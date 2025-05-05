package com.osumba.userservice.service;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import com.osumba.userservice.exception.AddressNotFoundException;
import com.osumba.userservice.exception.UserNotFoundException;
import com.osumba.userservice.mapper.AddressMapper;
import com.osumba.userservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AddressService {

    public final AddressRepository addressRepository;
    public final AddressMapper addressMapper;

    public String createAddress(AddressRequest request) {
        var  address = addressRepository.save(addressMapper.toAddress(request));
        return String.valueOf(address.getId());
    }

    public void updateAddress(AddressRequest request) {
        var address = addressRepository.findById(request.id())
                .orElseThrow(()-> new AddressNotFoundException(
                        format("Cannot update address:: No address found with the provider ID::%S", request)
                ));
        mergerAddress(address, request);

        addressRepository.save(address);
    }

    private void mergerAddress(Address address, AddressRequest request) {
        if (StringUtils.isNotBlank(request.street())){
            address.setStreet(request.street());
        }
        if (StringUtils.isNotBlank(request.immNumber())){
            address.setImmNumber(request.immNumber());
        }
        if (StringUtils.isNotBlank(request.houseNumber())){
            address.setHouseNumber(request.houseNumber());
        }
        if (request.zipCode() != 0) {  // Verifique se o zipCode não é nulo
            address.setZipCode(request.zipCode());
        }

    }

    public List<AddressRecord> findAllAddress() {

        return addressRepository.findAll()
                .stream()
                .map(addressMapper::fromAddress)
                .collect(Collectors.toList());

    }

    public Boolean existsById(UUID addressId) {
        return addressRepository.findById(addressId).isPresent();

    }

    public AddressRecord findAddressById(UUID addressId) {
        return addressRepository.findById(addressId)
                .map(addressMapper::fromAddress)
                .orElseThrow(()-> new UserNotFoundException(format("No user Found with this ID:: %s", addressId)));
    }

    public void deleteAddressById(UUID addressId) { addressRepository.deleteById(addressId);
    }
}

package com.osumba.userservice.service;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import com.osumba.userservice.entity.User;
import com.osumba.userservice.exception.ExceptionType.AddressNotFoundException;
import com.osumba.userservice.exception.ExceptionType.UserNotFoundException;
import com.osumba.userservice.mapper.AddressMapper;
import com.osumba.userservice.repository.AddressRepository;
import com.osumba.userservice.repository.UserRepository;
import com.osumba.userservice.service.implementService.ImpAddress;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service

public class AddressService implements ImpAddress {

    @Autowired
    public  AddressRepository addressRepository;
    @Autowired
    public  AddressMapper addressMapper;

    @Autowired
    private UserRepository userRepository;






    @Override
    @Transactional
    public UUID createAddress(AddressRequest request) {
        Optional<User> optionalUser = this.userRepository.findById(request.user().getId());

        if (!optionalUser.isPresent()){
            throw new UserNotFoundException("The given user ID "+request.user().getId()+" is not exist");
        }
        var address = this.addressRepository.save(addressMapper.toAddress(request));
        return address.getId();
    }

    /*
        @Override
        @Transactional
        public Address createAddress(AddressRequest request) {

            Optional<User> optionalUser = this.userRepository.findById(request.user().getId());

            if (!optionalUser.isPresent()){
                throw new UserNotFoundException("The given user ID "+request.user().getId()+" is not exist");
            }

          //  User user = optionalUser.get();

            Address address = new Address();
            address.setCountry(request.country());
            address.setState(request.state());
            address.setCity(request.city());
            address.setStreet(request.street());
            address.setHouseNumber(request.houseNumber());
            address.setZipCode(request.zipCode());
            address.setImmNumber(request.immNumber());
            address.setUser(request.user());

            return addressRepository.save(addressMapper.toAddress(request));

        }
    */
    @Override
    public Address updateAddress(UUID addressId, AddressRequest request) {

        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isEmpty()){
            throw new AddressNotFoundException("The given Address ID:"+addressId+" does not exist !");
        }


        Address address1 = address.get();
        mergerAddress(address1, request);

        return  addressRepository.save(address1);
    }

    @Override
    public void mergerAddress(Address address, AddressRequest request) {
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


    @Override
    public List<AddressRecord> findAllAddress() {

        return addressRepository.findAll()
                .stream()
                .map(addressMapper::fromAddress)
                .collect(Collectors.toList());

    }

    @Override
    public Boolean existsById(UUID addressId) {
        return addressRepository.findById(addressId).isPresent();

    }

    @Override
    public AddressRecord findAddressById(UUID addressId) {
        return addressRepository.findById(addressId)
                .map(addressMapper::fromAddress)
                .orElseThrow(()-> new UserNotFoundException("No user Found with this ID::"+ addressId));
    }

    @Override
    public void deleteAddressById(UUID addressId) {

        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isEmpty()){
            throw new AddressNotFoundException("The Address is not"+addressId+" exist");
        }
        addressRepository.deleteById(addressId);
    }
}

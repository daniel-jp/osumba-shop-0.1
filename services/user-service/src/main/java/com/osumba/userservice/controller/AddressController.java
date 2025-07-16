package com.osumba.userservice.controller;

import com.osumba.userservice.dto.AddressRecord;
import com.osumba.userservice.dto.AddressRequest;
import com.osumba.userservice.entity.Address;
import com.osumba.userservice.repository.UserRepository;
import com.osumba.userservice.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")

public class AddressController {
    @Autowired
    private AddressService addressService;


    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody @Valid AddressRequest request){

         addressService.createAddress(request);
        return   ResponseEntity.ok("Address created successful ✅");
    }

    @PutMapping(path = "/{address-id}")
    public ResponseEntity<String> updateAddress(
            @PathVariable("address-id")UUID addressId,
            @RequestBody @Valid AddressRequest request   ){
        addressService.updateAddress(addressId, request);
        return ResponseEntity.ok("Address number : "+request.immNumber()+" Updated successful ✅");
    }


    @GetMapping
    public ResponseEntity<List<AddressRecord>> findAll(){

        return ResponseEntity.ok(addressService.findAllAddress());
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") UUID addressId){
       return ResponseEntity.ok(addressService.existsById(addressId)) ;
    }

    @GetMapping("/find-address/{address-id}")
    public ResponseEntity<AddressRecord> findAddressById(
            @PathVariable("address-id") UUID addressId){
        return ResponseEntity.ok(addressService.findAddressById(addressId)) ;
    }

    @DeleteMapping("/delete-address/{address-id}")
    public ResponseEntity<String> deleteAddressById(
            @PathVariable("address-id") UUID addressId){
        addressService.deleteAddressById(addressId);
        return ResponseEntity.ok("Address Deleted successful  ✅");
    }






}

package com.osumba.userservice.controller;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UUID> createUser(@RequestBody @Valid UserRequest request){
        return   ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateUSer(@RequestBody @Valid UserRequest request ){
        userService.updateUser(request);
        return ResponseEntity.accepted().build();
    }


    @GetMapping
    public ResponseEntity<List<UserRecord>> findAll(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") UUID userId){
       return ResponseEntity.ok(userService.existsById(userId)) ;
    }

    @GetMapping("/find-user/{customer-id}")
    public ResponseEntity<UserRecord> findUserById(
            @PathVariable("customer-id") UUID userId){
        return ResponseEntity.ok(userService.findUserById(userId)) ;
    }

    @GetMapping("/delete-user/{customer-id}")
    public ResponseEntity<Void> deleteUserById(
            @PathVariable("customer-id") UUID userId){
        userService.deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }


}

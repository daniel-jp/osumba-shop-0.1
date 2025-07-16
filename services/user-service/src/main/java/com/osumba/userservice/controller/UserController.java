package com.osumba.userservice.controller;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.entity.User;
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
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest request){
        return   ResponseEntity.ok("User with ID :[ "+userService.createUser(request)+" ] Well added successful ✅");
    }

    @PutMapping(path = "/{user-id}")
    public ResponseEntity<String> updateUSer(@PathVariable("user-id") UUID userId, @RequestBody @Valid UserRequest request ){

        userService.updateUser(userId, request);
        return ResponseEntity.ok("Usr with ID: [ "+userId+" ] Updated successful ✅");
    }


    @GetMapping
    public ResponseEntity<List<UserRecord>> findAll(){
        return ResponseEntity.ok(userService.findAllUser());
    }



    // TIS CODE IS TO TEST IF THE USER IS PRESENT DATABASE. IF PRSENTE RETURN TRUE
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

    @DeleteMapping("/delete-user/{customer-id}")
    public ResponseEntity<String> deleteUserById(
            @PathVariable("customer-id") UUID userId){
        userService.deleteUserById(userId);
        //return ResponseEntity.accepted().build();
        return ResponseEntity.ok("User deleted successful ✅");
    }


}

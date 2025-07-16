package com.osumba.userservice.service.implementService;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.entity.User;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

public interface ImpUser {


     UUID createUser(UserRequest request) ;

     User updateUser(UUID userId,UserRequest request);
     void mergerUser(User user, UserRequest request);
     List<UserRecord> findAllUser() ;

     Boolean existsById(UUID userId);

     UserRecord findUserById(UUID userId);

     void deleteUserById(UUID userId);
}

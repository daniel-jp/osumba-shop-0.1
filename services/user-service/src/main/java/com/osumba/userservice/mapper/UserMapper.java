package com.osumba.userservice.mapper;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.entity.User;
import com.osumba.userservice.enumer.UserRole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserMapper {

    public User toUser(UserRequest request) {
        if (request == null){
            return null;
        }

        return User.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .birthDate(new Date())
                .userRole(UserRole.CUSTOMER)
                .isActive(true)
                .build();
    }

    public UserRecord fromUser(User user) {
        return new UserRecord(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getBirthDate(),
                user.getUserRole(),
                user.isActive()
        );
    }

}

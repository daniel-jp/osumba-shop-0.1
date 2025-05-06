package com.osumba.userservice.service;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.entity.User;
import com.osumba.userservice.exception.UserNotFoundException;
import com.osumba.userservice.mapper.UserMapper;
import com.osumba.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final UserMapper userMapper;

    public UUID createUser(UserRequest request) {
        var  user = userRepository.save(userMapper.toUser(request));
        return user.getId();
    }

    public void updateUser(UserRequest request) {
        var user = userRepository.findById(request.id())
                .orElseThrow(()-> new UserNotFoundException(
                        format("Cannot update user:: No user found with the provider ID::%S", request)
                ));
        mergerUser(user, request);

        userRepository.save(user);
    }

    private void mergerUser(User user, UserRequest request) {

        if (StringUtils.isNotBlank(request.firstName())){
            user.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            user.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.firstName())){
            user.setEmail(request.email());
        }
        if (StringUtils.isNotBlank(request.firstName())){
            user.setPassword(request.password());
        }

    }

    public List<UserRecord> findAllUser() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::fromUser)
                .collect(Collectors.toList());

    }


    public Boolean existsById(UUID userId) {
        return userRepository.findById(userId).isPresent();

    }

    public UserRecord findUserById(UUID userId) {
        return userRepository.findById(userId)
                .map(userMapper::fromUser)
                .orElseThrow(()-> new UserNotFoundException(format("No user Found with this ID:: %s", userId)));
    }

    public void deleteUserById(UUID userId) { userRepository.deleteById(userId);
    }
}

package com.osumba.userservice.service;

import com.osumba.userservice.dto.UserRecord;
import com.osumba.userservice.dto.UserRequest;
import com.osumba.userservice.entity.User;
import com.osumba.userservice.exception.ExceptionType.UserNotFoundException;
import com.osumba.userservice.mapper.UserMapper;
import com.osumba.userservice.repository.UserRepository;
import com.osumba.userservice.service.implementService.ImpUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class UserService implements ImpUser {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserMapper userMapper;

    @Override
    public UUID createUser(UserRequest request) {

        var user = userRepository.save(userMapper.toUser(request));
        return user.getId();
    }

    @Override
    public User updateUser(UUID userId,UserRequest request) {

        Optional<User> optionalUseruser = userRepository.findById(userId) ;
       if (optionalUseruser.isEmpty()) {
           throw new UserNotFoundException(String.format( "The given ID:" +userId+" does not exist!"));
       }
        User existingUser = optionalUseruser.get();

        // Atualiza os campos com os valores do request
        mergerUser(existingUser, request);

        return userRepository.save(existingUser);
}

    @Override
    public void mergerUser(User user, UserRequest request) {
        // Atualizações condicionais
        if (StringUtils.isNotBlank(request.firstName())) {
            user.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            user.setEmail(request.email());
        }

    }


    @Override
    public List<UserRecord> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::fromUser)
                .collect(Collectors.toList());
    }


    // TIS CODE IS TO TEST IF THE USER IS PRESENT DATABASE
    @Override
    public Boolean existsById(UUID userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public UserRecord findUserById(UUID userId) {
        return userRepository.findById(userId)
                .map(userMapper::fromUser)
                .orElseThrow(()-> new UserNotFoundException("No user Found with this ID::"+userId));

    }

    @Override
    public void deleteUserById(UUID userId) {

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException("Te User with ID :"+ userId +" not exist ❗" );
        }
        userRepository.deleteById(userId);
    }

}

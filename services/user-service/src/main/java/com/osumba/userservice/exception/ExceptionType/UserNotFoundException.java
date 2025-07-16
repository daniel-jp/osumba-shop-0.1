package com.osumba.userservice.exception.ExceptionType;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
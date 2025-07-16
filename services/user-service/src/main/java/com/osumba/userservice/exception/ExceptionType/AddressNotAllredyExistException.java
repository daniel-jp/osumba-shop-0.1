package com.osumba.userservice.exception.ExceptionType;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class AddressNotAllredyExistException extends RuntimeException {

    public AddressNotAllredyExistException(String message) {
        super(message);
    }
}

package com.osumba.userservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class AddressNotFoundException extends RuntimeException {

    private final String msg;
}

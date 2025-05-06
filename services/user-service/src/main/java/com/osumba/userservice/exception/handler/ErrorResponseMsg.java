package com.osumba.userservice.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
public class ErrorResponseMsg {

    private Map<String, String> errors;
    public ErrorResponseMsg(Map<String, String> errors) {
        this.errors = errors;
    }
}

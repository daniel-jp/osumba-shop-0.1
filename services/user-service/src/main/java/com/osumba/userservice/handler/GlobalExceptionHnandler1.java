package com.osumba.userservice.handler;

import com.osumba.userservice.exception.AddressNotFoundException;
import com.osumba.userservice.exception.UserNotFoundException;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHnandler1 {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handle(UserNotFoundException exp) {
        return ResponseEntity
                .status(HttpStatus.SC_NOT_FOUND)
                .body(exp.getMsg());
    }


    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> handle(AddressNotFoundException exp) {
        return ResponseEntity
                .status(HttpStatus.SC_NOT_FOUND)
                .body(exp.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseMsg> handle(MethodArgumentNotValidException exp){
        var errors = new HashMap<String, String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error->{
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage= error.getDefaultMessage();

                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity
                .status(HttpStatus.SC_BAD_REQUEST)
                .body(new ErrorResponseMsg());

    }
}

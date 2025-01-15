package com.osumba.product_service.exception.productException;

public class CategoryNotFoundException extends RuntimeException {

     public CategoryNotFoundException(String message) {
        super(message);
    }
}

package com.osumba.product_service.exception.productException;

public class ProductAlreadExistException extends RuntimeException {

     public ProductAlreadExistException(String message) {
        super(message);
    }
}

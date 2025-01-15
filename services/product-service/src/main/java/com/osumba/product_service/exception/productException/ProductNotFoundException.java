package com.osumba.product_service.exception.productException;

public class ProductNotFoundException extends RuntimeException {

     public ProductNotFoundException (String message) {
        super(message);
    }
}

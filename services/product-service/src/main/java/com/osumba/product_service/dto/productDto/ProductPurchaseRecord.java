package com.osumba.product_service.dto.productDto;



public record ProductPurchaseRecord(
        String name,
        String description,
        double price,
        int quantityInStock){

}

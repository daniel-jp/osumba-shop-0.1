package com.osumba.product_service.dto.productDto;

import com.osumba.product_service.entity.CategoryProd;


public record ProductRequest(

         String name,
         String description,
         int quantityInStock,
         double price,
         CategoryProd category
) {
}

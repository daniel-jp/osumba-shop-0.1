package com.osumba.product_service.Mapper;

import com.osumba.product_service.dto.product.ProductPurchaseResponse;
import com.osumba.product_service.dto.product.ProductRequest;
import com.osumba.product_service.dto.product.ProductResponse;
import com.osumba.product_service.entity.CategoryProd;
import com.osumba.product_service.entity.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;


@Service
public class ProductMapper {


    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .quantityInStock(request.quantityInStock())
                .price(request.price())
                .imageUrl(request.imageUrl())
                .dataAdded(new Date())
                .category(
                        CategoryProd.builder()
                        .id(request.category().getId())
                        .build()
                )
                .build();
    }


    public  ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantityInStock(),
                product.getPrice(),
                product.getImageUrl(),
                product.getDataAdded(),
                product.getCategory()
        );
    }

    public ProductPurchaseResponse toproductPurchaseResponse(Product product, int quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}

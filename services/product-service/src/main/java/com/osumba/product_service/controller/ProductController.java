package com.osumba.product_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.osumba.product_service.dto.productDto.ProductPurchaseRecord;
import com.osumba.product_service.dto.productDto.ProductPurchaseRequests;
import com.osumba.product_service.dto.productDto.ProductRecord;
import com.osumba.product_service.dto.productDto.ProductRequest;
import com.osumba.product_service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(
            @RequestBody @Valid ProductRequest request){
        productService .createProduct(request);
        return ResponseEntity.ok("Product registered successfully ✅");
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseRecord>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequests> request) {
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }


    @GetMapping("/{product-id}")
    public ResponseEntity<ProductRecord> findById(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductRecord>> findAll() {
        return ResponseEntity.ok(productService.findAllProduct());
    }

}

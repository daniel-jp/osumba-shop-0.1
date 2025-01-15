package com.osumba.product_service.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osumba.product_service.dto.productDto.ProductPurchaseRecord;
import com.osumba.product_service.dto.productDto.ProductPurchaseRequests;
import com.osumba.product_service.dto.productDto.ProductRecord;
import com.osumba.product_service.dto.productDto.ProductRequest;
import com.osumba.product_service.entity.Product;
import com.osumba.product_service.exception.productException.ProductNotFoundException;
import com.osumba.product_service.exception.productException.ProductPurchaseException;
import com.osumba.product_service.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    public ResponseEntity<String> createProduct(ProductRequest request) {
        // Criação de produto sem o uso de @Builder
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setQuantityInStock(request.quantityInStock());
        product.setPrice(request.price());
        product.setCategory(request.category());

        repository.save(product);
        return ResponseEntity.ok().build();
    }

    public ProductRecord findProductById(Long id) {
        return repository.findById(id)
                .map(product -> new ProductRecord(
                        product.getName(),
                        product.getDescription(),
                        product.getQuantityInStock(),
                        product.getPrice(),
                        product.getCategory()
                ))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID:: " + id));
    }

    public List<ProductRecord> findAllProduct() {
        return repository.findAll()
                .stream()
                .map(product -> new ProductRecord(
                        product.getName(),
                        product.getDescription(),
                        product.getQuantityInStock(),
                        product.getPrice(),
                        product.getCategory()
                ))
                .collect(Collectors.toList());
    }



    @Transactional
    public List<ProductPurchaseRecord> purchaseProducts(List<ProductPurchaseRequests> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequests::productId)
                .toList();

        var storedProducts = repository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }

        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequests::productId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseRecord>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getQuantityInStock() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }

            // Atualiza o estoque do produto
            var newAvailableQuantity = product.getQuantityInStock() - productRequest.quantity();
            product.setQuantityInStock(newAvailableQuantity);
            repository.save(product);

            // Adiciona o ProductPurchaseRecord à lista de compras
            purchasedProducts.add(new ProductPurchaseRecord(

                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    productRequest.quantity()
            ));
        }

        return purchasedProducts;
    }


}

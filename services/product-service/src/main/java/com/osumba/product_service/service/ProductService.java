package com.osumba.product_service.service;

import com.osumba.product_service.Mapper.ProductMapper;
import com.osumba.product_service.entity.Product;
import com.osumba.product_service.exception.productException.ProductAlreadExistException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osumba.product_service.dto.product.ProductPurchaseResponse;
import com.osumba.product_service.dto.product.ProductPurchaseRequest;
import com.osumba.product_service.dto.product.ProductResponse;
import com.osumba.product_service.dto.product.ProductRequest;
import com.osumba.product_service.exception.productException.ProductPurchaseException;
import com.osumba.product_service.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public Product createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        if (product.getId()!= null){
            throw new ProductAlreadExistException("A product  with " +request.id()+" already exists");
        }

        return  repository.save(product);
    }

    public ProductResponse findProductById(UUID id) {
        return repository.findById(id)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + id));
    }

    public List<ProductResponse> findAllProduct() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }


    @Transactional()
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {

        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        List<Product> storedProducts = repository.findAllByIdInOrderById(productIds);



        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }

        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);

            if (product.getQuantityInStock() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: "
                        + productRequest.productId());
            }

            int  newAvailableQuantity = product.getQuantityInStock() - productRequest.quantity();
            product.setQuantityInStock(newAvailableQuantity);
            repository.save(product);
            purchasedProducts.add(mapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }
}

package com.osumba.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.product_service.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIdInOrderById(List<Long> ids);
}

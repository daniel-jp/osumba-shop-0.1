package com.osumba.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.product_service.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByIdInOrderById(List<UUID> ids);

}


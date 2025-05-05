package com.osumba.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.product_service.entity.CategoryProd;

import java.util.UUID;

public interface CategoryRepository  extends JpaRepository<CategoryProd, UUID> {
}

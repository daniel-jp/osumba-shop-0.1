package com.osumba.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osumba.product_service.entity.CategoryProd;

public interface CategoryRepository  extends JpaRepository<CategoryProd, Long> {
}

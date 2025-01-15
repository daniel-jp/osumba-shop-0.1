package com.osumba.product_service.controller;


import com.osumba.product_service.entity.CategoryProd;
import com.osumba.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<CategoryProd> createCustomer(@RequestBody CategoryProd category) {
        System.out.println("Received POST request to create customer: " + category);
        CategoryProd category1 = categoryRepository.save(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoryProd> categoryList(){
        return categoryRepository.findAll();
    }
}

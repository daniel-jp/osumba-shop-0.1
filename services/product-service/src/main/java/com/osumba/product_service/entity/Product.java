package com.osumba.product_service.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int quantityInStock;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProd category;

    public Product() {
    }

    public Product(String name, int quantityInStock, String description, double price, CategoryProd category) {
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryProd getCategory() {
        return category;
    }

    public void setCategory(CategoryProd category) {
        this.category = category;
    }
}


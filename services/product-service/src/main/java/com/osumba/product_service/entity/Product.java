package com.osumba.product_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private int quantityInStock;
    private BigDecimal price;
    private String imageUrl;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataAdded;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProd category;


}


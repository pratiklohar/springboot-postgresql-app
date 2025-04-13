package com.project.app.springboot_postgresql_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_weight", nullable = false)
    private Double unitWeight;

    @Column(name = "weight_type", nullable = false)
    private String weightType;

    @Column(name = "packaging_type", nullable = false)
    private String packagingType;
}

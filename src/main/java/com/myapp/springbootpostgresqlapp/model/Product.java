package com.myapp.springbootpostgresqlapp.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_weight", nullable = false)
    private Integer unitWeight;

    @Column(name = "weight_type", nullable = false)
    private String weightType;

    @Column(name = "packaging_type", nullable = false)
    private String packagingType;
}

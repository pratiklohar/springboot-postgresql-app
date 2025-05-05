package com.myapp.springbootpostgresqlapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_weight")
    private Integer unitWeight;

    @Column(name = "weight_type")
    private String weightType;

    @Column(name = "packaging_type")
    private String packagingType;
}

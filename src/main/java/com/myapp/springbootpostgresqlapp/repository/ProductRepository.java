package com.myapp.springbootpostgresqlapp.repository;

import com.myapp.springbootpostgresqlapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Define additional custom queries here if needed
    // For example, you can add methods to find products by name, category, etc.
    // Example: List<Product> findByName(String name);

    // Check if a product with the same name, category ID, unit weight, and weight type exists.
    boolean existsByProductNameAndCategoryIdAndUnitWeightAndWeightType(
            String productName,
            UUID categoryId,
            Integer unitWeight,
            String weightType
    );
}


package com.myapp.springbootpostgresqlapp.repository;

import com.myapp.springbootpostgresqlapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Define additional custom queries here if needed
    // For example, you can add methods to find products by name, category, etc.
    // Example: List<Product> findByName(String name);
}

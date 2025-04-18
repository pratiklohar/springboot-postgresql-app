package com.myapp.springbootpostgresqlapp.repository;

import com.myapp.springbootpostgresqlapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Define additional custom queries here if needed
}
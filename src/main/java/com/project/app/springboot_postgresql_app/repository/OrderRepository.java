package com.project.app.springboot_postgresql_app.repository;

import com.project.app.springboot_postgresql_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Define additional custom queries here if needed
}
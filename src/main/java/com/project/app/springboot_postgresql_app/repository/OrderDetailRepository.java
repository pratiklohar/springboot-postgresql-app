package com.project.app.springboot_postgresql_app.repository;

import com.project.app.springboot_postgresql_app.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Define additional custom queries here if needed
}
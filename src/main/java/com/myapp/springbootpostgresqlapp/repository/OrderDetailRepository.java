package com.myapp.springbootpostgresqlapp.repository;

import com.myapp.springbootpostgresqlapp.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Define additional custom queries here if needed
}
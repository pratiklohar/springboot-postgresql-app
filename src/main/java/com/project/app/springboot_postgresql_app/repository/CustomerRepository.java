package com.project.app.springboot_postgresql_app.repository;

import com.project.app.springboot_postgresql_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Define additional custom queries here if needed
}
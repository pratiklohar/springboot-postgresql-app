package com.myapp.springbootpostgresqlapp.repository;

import com.myapp.springbootpostgresqlapp.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Define additional custom queries here if needed


    @Override
    Page<Customer> findAll(Pageable pageable);


}
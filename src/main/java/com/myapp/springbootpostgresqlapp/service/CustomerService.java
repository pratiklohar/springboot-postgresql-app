package com.myapp.springbootpostgresqlapp.service;

import com.myapp.springbootpostgresqlapp.dto.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    // Define methods for customer service operations
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto addCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}

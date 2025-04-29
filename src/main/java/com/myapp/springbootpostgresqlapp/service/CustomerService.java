package com.myapp.springbootpostgresqlapp.service;

import com.myapp.springbootpostgresqlapp.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    // Define methods for customer service operations
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Integer customerId);

    CustomerDto addCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(Integer customerId, CustomerDto customerDto);

    void deleteCustomer(Integer customerId);
}

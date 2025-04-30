package com.myapp.springbootpostgresqlapp.controller;

import com.myapp.springbootpostgresqlapp.constants.AppConstants;
import com.myapp.springbootpostgresqlapp.dto.ApiResponse;
import com.myapp.springbootpostgresqlapp.dto.CustomerDto;
import com.myapp.springbootpostgresqlapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerDto>>> getAllCustomers() {
        var customers = customerService.getAllCustomers();
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                customers
        );
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDto>> getCustomerById(@PathVariable Integer customerId) {
        var product = customerService.getCustomerById(customerId);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                product
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerDto>> addCustomer(@RequestBody CustomerDto customerDto) {
        var savedProduct = customerService.addCustomer(customerDto);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                savedProduct
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDto>> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDto customerDto) {
        var updatedProduct = customerService.updateCustomer(customerId, customerDto);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                updatedProduct
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse<Object>> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                null
        );
        return ResponseEntity.ok(response);
    }
}

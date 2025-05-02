package com.myapp.springbootpostgresqlapp.controller;

import com.myapp.springbootpostgresqlapp.constants.AppConstants;
import com.myapp.springbootpostgresqlapp.dto.ApiResponse;
import com.myapp.springbootpostgresqlapp.dto.CustomerDto;
import com.myapp.springbootpostgresqlapp.service.CustomerService;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(ApiResponse.success(customerService.getAllCustomers()));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDto>> getCustomerById(@PathVariable Integer customerId) {
        return ResponseEntity.ok(ApiResponse.success(customerService.getCustomerById(customerId)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerDto>> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(ApiResponse.success(customerService.addCustomer(customerDto)));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDto>> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(ApiResponse.success(customerService.updateCustomer(customerId, customerDto)));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse<?>> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}

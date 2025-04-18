package com.myapp.springbootpostgresqlapp.controller;

import com.myapp.springbootpostgresqlapp.constants.AppConstants;
import com.myapp.springbootpostgresqlapp.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myapp.springbootpostgresqlapp.service.ProductService;
import com.myapp.springbootpostgresqlapp.dto.ProductDto;


import java.util.List;
@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
        var products = productService.getAllProducts();
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                products
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable Long id) {
         var product = productService.getProductById(id);
         var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                product
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@RequestBody ProductDto productDto) {
        var savedProduct = productService.addProduct(productDto);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                savedProduct
        );
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        var updatedProduct = productService.updateProduct(id, productDto);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                updatedProduct
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        var response = new ApiResponse<>(
                AppConstants.SUCCESS,
                null
        );
        return ResponseEntity.ok(response);
    }
}

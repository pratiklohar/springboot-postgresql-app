package com.myapp.springbootpostgresqlapp.controller;

import com.myapp.springbootpostgresqlapp.constants.AppConstants;
import com.myapp.springbootpostgresqlapp.dto.ApiResponse;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(ApiResponse.success(productService.getAllProducts()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable Integer productId) {
        return ResponseEntity.ok(ApiResponse.success(productService.getProductById(productId)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.ok(ApiResponse.success(productService.addProduct(productDto)));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable Integer productId, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(ApiResponse.success(productService.updateProduct(productId, productDto)));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}

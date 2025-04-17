package com.project.app.springboot_postgresql_app.controller;

import com.project.app.springboot_postgresql_app.constants.AppConstants;
import com.project.app.springboot_postgresql_app.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.app.springboot_postgresql_app.service.ProductService;
import com.project.app.springboot_postgresql_app.dto.ProductDto;


import java.util.List;
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable Long id) {
         var product = productService.getProductById(id);
        ApiResponse<ProductDto> response = new ApiResponse<>(
                AppConstants.SUCCESS,
                product
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@RequestBody ProductDto productDto) {
        var savedProduct = productService.addProduct(productDto);
        ApiResponse<ProductDto> response = new ApiResponse<>(
                AppConstants.SUCCESS,
                savedProduct
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        AppConstants.SUCCESS,
                        null
                )
        );
    }
    
    
    
}

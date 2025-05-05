package com.myapp.springbootpostgresqlapp.service;

import java.util.List;
import java.util.UUID;

import com.myapp.springbootpostgresqlapp.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(UUID productId);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(UUID productId, ProductDto productDto);

    void deleteProduct(UUID productId);
}

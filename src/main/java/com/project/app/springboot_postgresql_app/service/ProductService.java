package com.project.app.springboot_postgresql_app.service;

import java.util.List;
import com.project.app.springboot_postgresql_app.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}

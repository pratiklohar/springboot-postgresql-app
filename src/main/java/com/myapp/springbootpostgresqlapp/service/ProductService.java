package com.myapp.springbootpostgresqlapp.service;

import java.util.List;
import com.myapp.springbootpostgresqlapp.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}

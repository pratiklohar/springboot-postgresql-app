package com.myapp.springbootpostgresqlapp.service;

import java.util.List;
import com.myapp.springbootpostgresqlapp.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Integer productId);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(Integer productId, ProductDto productDto);

    void deleteProduct(Integer productId);
}

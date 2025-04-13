package com.project.app.springboot_postgresql_app.service.impl;

import com.project.app.springboot_postgresql_app.dto.ProductDto;
import com.project.app.springboot_postgresql_app.repository.ProductRepository;
import com.project.app.springboot_postgresql_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired



    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}

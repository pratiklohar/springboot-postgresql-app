package com.project.app.springboot_postgresql_app.service.impl;

import com.project.app.springboot_postgresql_app.constants.AppConstants;
import com.project.app.springboot_postgresql_app.constants.ErrorMessages;
import com.project.app.springboot_postgresql_app.dto.ProductDto;
import com.project.app.springboot_postgresql_app.exception.ResourceNotFoundException;
import com.project.app.springboot_postgresql_app.mapper.ProductMapper;
import com.project.app.springboot_postgresql_app.repository.ProductRepository;
import com.project.app.springboot_postgresql_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.locks.Condition;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND)));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        if (productDto.getProductId() != null && productRepository.existsById(productDto.getProductId())) {
            throw new RuntimeException(ErrorMessages.PRODUCT_EXIST);
        }
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
        productMapper.updateProductFromDto(productDto, product);
        return productMapper.toDto(productRepository.save(product));
    }
    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(id);
    }
}

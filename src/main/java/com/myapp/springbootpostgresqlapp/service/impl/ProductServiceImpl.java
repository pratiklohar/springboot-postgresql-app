package com.myapp.springbootpostgresqlapp.service.impl;

import com.myapp.springbootpostgresqlapp.constants.ErrorMessages;
import com.myapp.springbootpostgresqlapp.dto.ProductDto;
import com.myapp.springbootpostgresqlapp.exception.ResourceNotFoundException;
import com.myapp.springbootpostgresqlapp.mapper.ProductMapper;
import com.myapp.springbootpostgresqlapp.repository.ProductRepository;
import com.myapp.springbootpostgresqlapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        return productMapper.toDto(productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND)));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        var product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
        productMapper.updateProductFromDto(productDto, product);
        return productMapper.toDto(productRepository.save(product));
    }
    @Override
    public void deleteProduct(Integer productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(productId);
    }
}

package com.myapp.springbootpostgresqlapp.service.impl;

import com.myapp.springbootpostgresqlapp.constants.ErrorMessages;
import com.myapp.springbootpostgresqlapp.dto.ProductDto;
import com.myapp.springbootpostgresqlapp.exception.ResourceNotFoundException;
import com.myapp.springbootpostgresqlapp.model.Product;
import com.myapp.springbootpostgresqlapp.repository.ProductRepository;
import com.myapp.springbootpostgresqlapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        if (productRepository.existsByProductNameAndCategoryIdAndUnitWeightAndWeightType(
                productDto.productName(),
                productDto.categoryId(),
                productDto.unitWeight(),
                productDto.weightType()
        )) {
            throw new ResourceNotFoundException(ErrorMessages.PRODUCT_EXIST);
        } else {
            return toDto(productRepository.save(toEntity(productDto)));
        }
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
        return toDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(productId);
    }

    // Convert the Product entity to Product DTO
    private ProductDto toDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getCategoryId(),
                product.getPrice(),
                product.getQuantity(),
                product.getUnitWeight(),
                product.getWeightType(),
                product.getPackagingType()
        );
    }

    // Convert the Product DTO to Product entity
    private Product toEntity(ProductDto productDto) {
        return new Product(
                productDto.productId(),
                productDto.productName(),
                productDto.categoryId(),
                productDto.price(),
                productDto.quantity(),
                productDto.unitWeight(),
                productDto.weightType(),
                productDto.packagingType()
        );
    }
}


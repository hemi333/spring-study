package com.example.mySelectShop.service;

import com.example.mySelectShop.dto.ProductRequestDto;
import com.example.mySelectShop.dto.ProductResponseDto;
import com.example.mySelectShop.entity.Product;
import com.example.mySelectShop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
}

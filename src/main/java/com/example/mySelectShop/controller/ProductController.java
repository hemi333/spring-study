package com.example.mySelectShop.controller;

import com.example.mySelectShop.dto.ProductMypriceRequestDto;
import com.example.mySelectShop.dto.ProductRequestDto;
import com.example.mySelectShop.dto.ProductResponseDto;
import com.example.mySelectShop.entity.Product;
import com.example.mySelectShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }
}

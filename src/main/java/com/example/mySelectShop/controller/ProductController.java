package com.example.mySelectShop.controller;

import com.example.mySelectShop.dto.ProductMypriceRequestDto;
import com.example.mySelectShop.dto.ProductRequestDto;
import com.example.mySelectShop.dto.ProductResponseDto;
import com.example.mySelectShop.entity.Product;
import com.example.mySelectShop.security.UserDetailsImpl;
import com.example.mySelectShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(requestDto, userDetails.getUser());
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }

    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
       return productService.getProducts(userDetails.getUser(),page-1, size, sortBy, isAsc);
    }
}

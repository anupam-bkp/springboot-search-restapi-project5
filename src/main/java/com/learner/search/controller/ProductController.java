package com.learner.search.controller;


import com.learner.search.dto.ProductDto;
import com.learner.search.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8080/api/vi/products/search?query=some_product
    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam("query") String query){
        List<ProductDto> productDtoList = productService.searchProducts(query);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
}

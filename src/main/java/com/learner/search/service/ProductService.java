package com.learner.search.service;

import com.learner.search.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> searchProducts(String query);

    ProductDto createProduct(ProductDto productDto);
}

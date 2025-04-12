package com.learner.search.service.impl;

import com.learner.search.dto.ProductDto;
import com.learner.search.entity.Product;
import com.learner.search.mapper.ProductMapper;
import com.learner.search.repository.ProductRepository;
import com.learner.search.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> searchProducts(String query) {

        List<Product> products = productRepository.searchProducts(query);
        List<ProductDto> productDtoList = products.stream().map(mapper::convertToDto).toList();

        return productDtoList;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product savedProduct = productRepository.save(mapper.convertToEntity(productDto));
        return mapper.convertToDto(savedProduct);
    }

}

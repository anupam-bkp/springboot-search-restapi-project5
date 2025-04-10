package com.learner.search.mapper;

import com.learner.search.dto.ProductDto;
import com.learner.search.entity.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private final ModelMapper mapper = new ModelMapper();

    public Product convertToEntity(ProductDto productDto){
        return mapper.map(productDto, Product.class);
    }

    public ProductDto convertToDto(Product product){
        return mapper.map(product, ProductDto.class);
    }

}

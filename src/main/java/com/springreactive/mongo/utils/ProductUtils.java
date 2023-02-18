package com.springreactive.mongo.utils;


import com.springreactive.mongo.dto.ProductDto;
import com.springreactive.mongo.entity.Product;
import org.springframework.beans.BeanUtils;

// We don't directly use the entity classes from service
// We use dto classes instead
// So convert dto to entity and vice versa
public class ProductUtils {

    public static ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto dto){
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}

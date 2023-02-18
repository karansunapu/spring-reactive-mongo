package com.springreactive.mongo.service;

import com.springreactive.mongo.dto.ProductDto;
import com.springreactive.mongo.repository.ProductRepository;
import com.springreactive.mongo.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDto> getProducts(){
        return repository.findAll().map(ProductUtils::entityToDto);
    }

    public Mono<ProductDto> getProductById(String id){
        return repository.findById(id).map(ProductUtils::entityToDto);
    }

    public Flux<ProductDto> getProductsInRange(double min, double max){
        return repository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto){
        return productDto.map(ProductUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(ProductUtils::entityToDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDto, String id){
       return repository.findById(id)
               // update the product entity to productDto from RequestBody
                .flatMap(p->productDto.map(ProductUtils::dtoToEntity))
               // set the id of the product
               .doOnNext(p->p.setId(id))
               // save it
                .flatMap(repository::save)
                // return the Dto product
                .map(ProductUtils::entityToDto);
    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }
}

package com.springreactive.mongo.repository;


import com.springreactive.mongo.dto.ProductDto;
import com.springreactive.mongo.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

// it will be an interface ??

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);
}

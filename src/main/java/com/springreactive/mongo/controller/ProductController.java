package com.springreactive.mongo.controller;

import com.springreactive.mongo.dto.ProductDto;
import com.springreactive.mongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable String id){
        return service.getProductById(id);
    }

    @GetMapping("/price-range")
    public Flux<ProductDto> getProductInRange(@RequestParam("min") double min, @RequestParam("max") double max){
        return service.getProductsInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono){
        return service.saveProduct(productDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono,@PathVariable String id){
        return service.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }
}

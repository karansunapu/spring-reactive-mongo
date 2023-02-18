package com.springreactive.mongo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// to interact with the service layers

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;
    private String name;
    private int qty;
    private double price;
}

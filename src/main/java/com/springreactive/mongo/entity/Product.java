package com.springreactive.mongo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// we don't directly use the entity so we have Dto for it

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productDB")
public class Product {

    @Id
    private String id;
    private String name;
    private int qty;
    private double price;
}
